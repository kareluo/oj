package problems.p74;

import java.util.Arrays;

class SolutionPlus {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int middle = (top + bottom) >>> 1;
            int value = matrix[middle][0];
            if (value < target) top = middle + 1;
            else if (value > target) bottom = middle - 1;
            else return true;
        }
        top--;
        return top >= 0 && Arrays.binarySearch(matrix[top], target) >= 0;
    }
}