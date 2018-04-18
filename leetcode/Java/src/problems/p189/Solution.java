package problems.p189;

class Solution {

    public void rotate(int[] nums, int k) {
        rotate(nums, nums.length, k);
    }

    private void rotate(int[] nums, int length, int k) {
        k %= length;
        if (k == 0) return;
        int i = length - 1;

        while (i - k >= 0) {
            for (int j = i - k, b = i - k - k; j >= 0 && j > b; j--, i--) {
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
            }
        }

        rotate(nums, k, k - length % k);
    }
}