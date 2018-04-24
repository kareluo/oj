package problems.p238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = nums.length - 1, j = 1; i >= 0; i--) {
            output[i] = j;
            j *= nums[i];
        }

        for (int i = 0, j = 1; i < nums.length; i++) {
            output[i] *= j;
            j *= nums[i];
        }

        return output;
    }
}