package problems.p240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        if (matrix[0][0] > target || matrix[rows - 1][cols - 1] < target) {
            return false;
        }

        int index, rowBegin = 0, rowEnd = rows, colBegin = 0, colEnd = cols;

        index = search(matrix[0], 0, cols, target);
        if (index >= 0) return true;
        colEnd = -index - 1;

        index = search(matrix[rows - 1], 0, cols, target);
        if (index >= 0) return true;
        colBegin = -index - 1;

        index = search(matrix, colBegin, 0, rows, target);
        if (index >= 0) return true;
        rowEnd = -index - 1;

        index = search(matrix, colEnd - 1, 0, rows, target);
        if (index >= 0) return true;
        rowBegin = -index - 1;

        for (int i = rowBegin; i < rowEnd; i++) {
            if (search(matrix[i], colBegin, colEnd, target) >= 0) {
                return true;
            }
        }

        return false;
    }

    private static int search(int[] a, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    private static int search(int[][] a, int col, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid][col];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}