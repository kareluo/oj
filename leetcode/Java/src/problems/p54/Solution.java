package problems.p54;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] dRows = new int[]{0, 1, 0, -1};

    private static final int[] dCols = new int[]{1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> orders = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return orders;
        }

        int direction = 0;

        int row = 0, col = 0;

        int rows = matrix.length, cols = matrix[0].length;

        int elements = rows * cols;

        int[] limits = new int[]{matrix[0].length, matrix.length - 1};

        int limit = limits[0], index = 0;

        while (elements > 0) {
            orders.add(matrix[row][col]);
            if (--limit <= 0) {
                limits[index]--;
                index ^= 1;
                limit = limits[index];
                direction = (direction + 1) % 4;
            }
            row += dRows[direction];
            col += dCols[direction];
            elements--;
        }
        return orders;
    }
}