package problems.p766;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        if (row <= 1 || col <= 1) {
            return true;
        }

        for (int i = row + col - 2, x, y, e; i > 1; i--) {
            x = 0;
            y = row - i;
            if (i > row) {
                x = i - row;
                y = 0;
            }
            e = matrix[y][x];
            while (x < col && y < row) {
                if (matrix[y++][x++] != e) {
                    return false;
                }
            }
        }

        return true;
    }
}