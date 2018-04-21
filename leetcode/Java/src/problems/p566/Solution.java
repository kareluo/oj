package problems.p566;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }

        int or = 0, oc = 0, len = nums[0].length;
        int[][] reshaped = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshaped[i][j] = nums[or][oc++];
                if (oc >= len) {
                    or++;
                    oc = 0;
                }
            }
        }

        return reshaped;
    }
}