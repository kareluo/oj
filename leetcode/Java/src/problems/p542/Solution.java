package problems.p542;

class Solution {

    private static final int MAX = 100000;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        if (matrix[0].length == 0) {
            return new int[matrix.length][0];
        }

        int rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = MAX;
                    if (i > 0 && matrix[i - 1][j] + 1 < matrix[i][j]) {
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    }
                    if (j > 0 && matrix[i][j - 1] + 1 < matrix[i][j]) {
                        matrix[i][j] = matrix[i][j - 1] + 1;
                    }
                }
            }
        }

        int lastRow = rows - 1, lastCol = cols - 1;
        for (int i = lastRow; i >= 0; i--) {
            for (int j = lastCol; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    if (i < lastRow && matrix[i + 1][j] + 1 < matrix[i][j]) {
                        matrix[i][j] = matrix[i + 1][j] + 1;
                    }
                    if (j < lastCol && matrix[i][j + 1] + 1 < matrix[i][j]) {
                        matrix[i][j] = matrix[i][j + 1] + 1;
                    }
                }
            }
        }

        return matrix;
    }
}