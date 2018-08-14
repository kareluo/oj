package problems.p890;

class Solution {

    private Node[] nodes;

    // TODO 错误答案

    public boolean possibleBipartition(int N, int[][] dislikes) {
        nodes = new Node[N + 1];
        for (int[] dislike : dislikes) {
            if (nodes[dislike[0]] == null) {
                nodes[dislike[0]] = new Node(dislike[1]);
            } else {
                nodes[dislike[0]] = new Node(dislike[1], nodes[dislike[0]]);
            }
        }

        int k = 1;
        int[] visit = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (visit[i] == 0 && nodes[i] != null) {
                if (isCircle(i, visit, k++)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCircle(int node, int[] visit, int k) {
        if (visit[node] == k) {
            return true;
        }
        visit[node] = k;
        Node p = nodes[node];
        while (p != null) {
            if (isCircle(p.node, visit, k)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }

    private static class Node {
        private int node;

        private Node next;

        Node(int node) {
            this.node = node;
        }

        Node(int node, Node next) {
            this.node = node;
            this.next = next;
        }
    }
}