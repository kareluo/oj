package problems.p807;

class Solution {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] top_bottom = new int[grid.length];
        int[] left_right = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > top_bottom[j]) {
                    top_bottom[j] = grid[i][j];
                }
                if (grid[i][j] > left_right[i]) {
                    left_right[i] = grid[i][j];
                }
            }
        }

        int maxIncreasing = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                maxIncreasing += Math.min(top_bottom[j], left_right[i]) - grid[i][j];
            }
        }

        return maxIncreasing;
    }
}