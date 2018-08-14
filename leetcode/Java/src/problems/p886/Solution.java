package problems.p886;

import java.util.Arrays;

class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        int head = 1;
        int[] nodes = new int[N];
        int[][] extra = new int[(edges.length << 1) + 1][3];

        for (int[] edge : edges) {
            extra[head][0] = nodes[edge[0]];
            extra[head][1] = edge[1];
            extra[head][2] = edge[2] + 1;
            nodes[edge[0]] = head++;

            extra[head][0] = nodes[edge[1]];
            extra[head][1] = edge[0];
            extra[head][2] = edge[2] + 1;
            nodes[edge[1]] = head++;
        }

        int[] dist = new int[N];
        boolean[] visit = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        visit[0] = true;

        for (int i = nodes[0]; i != 0; i = extra[i][0]) {
            dist[extra[i][1]] = extra[i][2];
        }

        int moves = 1;

        while (true) {

            int index = 0, edge = Integer.MAX_VALUE;
            for (int i = 1; i < N; i++) {
                if (!visit[i] && dist[i] < edge) {
                    index = i;
                    edge = dist[i];
                }
            }

            if (visit[index]) break;

            visit[index] = true;
            if (dist[index] <= M) {
                moves++;
            }

            for (int i = nodes[index]; i != 0; i = extra[i][0]) {
                if (!visit[extra[i][1]] && dist[index] < dist[extra[i][1]] - extra[i][2]) {
                    dist[extra[i][1]] = dist[index] + extra[i][2];
                }
            }
        }

        int x, y;
        for (int[] edge : edges) {
            x = dist[edge[0]];
            y = dist[edge[1]];
            if (x > y) {
                x = y;
                y = dist[edge[0]];
            }
            if (x <= M - edge[2]) {
                moves += edge[2];
            } else {
                int move = 0;
                if (x < M) move += M - x;
                if (y < M) move += M - y;
                if (move > edge[2]) {
                    move = edge[2];
                }
                moves += move;
            }
        }

        return moves;
    }
}