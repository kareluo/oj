package problems.p200;

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] map = new int[rows][cols];
        int[] nodes = new int[rows * cols + 1];

        int island = 0;
        if (grid[0][0] == '1') {
            map[0][0] = ++island;
            nodes[island] = island;
        }

        for (int i = 1; i < cols; i++) {
            if (grid[0][i] == '1') {
                if (map[0][i - 1] == 0) {
                    map[0][i] = ++island;
                    nodes[island] = island;
                } else {
                    map[0][i] = map[0][i - 1];
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (grid[i][0] == '1') {
                if (map[i - 1][0] == 0) {
                    map[i][0] = ++island;
                    nodes[island] = island;
                } else {
                    map[i][0] = map[i - 1][0];
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] == '1') {
                    if (map[i - 1][j] == 0 || map[i][j - 1] == 0) {
                        map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                        if (map[i][j] == 0) {
                            map[i][j] = ++island;
                            nodes[island] = island;
                        }
                    } else {
                        if (map[i - 1][j] > map[i][j - 1]) {
                            map[i][j] = map[i - 1][j];
                            nodes[find(nodes, map[i][j - 1])] = find(nodes, map[i][j]);
                        } else {
                            map[i][j] = map[i][j - 1];
                            nodes[find(nodes, map[i - 1][j])] = find(nodes, map[i][j]);
                        }
                    }
                }
            }
        }

        int islands = 0;
        for (int i = 1; i <= island; i++) {
            if (find(nodes, i) == i) {
                islands++;
            }
        }

        return islands;
    }

    private int find(int[] nodes, int x) {
        if (nodes[x] != x) {
            return nodes[x] = find(nodes, nodes[x]);
        }
        return x;
    }
}