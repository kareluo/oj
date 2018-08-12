package problems.p59;

class Solution {

    private static final int[] dRows = new int[]{0, 1, 0, -1};

    private static final int[] dCols = new int[]{1, 0, -1, 0};

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int direction = 0;

        int i = 1, m = n * n;

        int row = 0, col = 0;

        int[] limits = new int[]{n, n - 1};

        int limit = limits[0], index = 0;

        while (i <= m) {
            matrix[row][col] = i;
            if (--limit <= 0) {
                limits[index]--;
                index ^= 1;
                limit = limits[index];
                direction = (direction + 1) % 4;
            }
            row += dRows[direction];
            col += dCols[direction];
            i++;
        }
        return matrix;
    }
}