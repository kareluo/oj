package problems.p887;

class Solution {
    public int projectionArea(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int area = 0;
        int row = grid.length, col = grid[0].length;
        int[] rows = new int[row], cols = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] > rows[i]) rows[i] = grid[i][j];
                if (grid[i][j] > cols[j]) cols[j] = grid[i][j];
                if (grid[i][j] > 0) area++;
            }
        }
        for (int h : rows) area += h;
        for (int h : cols) area += h;
        return area;
    }
}