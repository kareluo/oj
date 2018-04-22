package problems.p169;

class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sums = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                sums[i] += (num >> i) & 1;
            }
        }

        int maj = 0, half = nums.length >> 1;
        for (int i = 31; i >= 0; i--) {
            maj = (maj << 1) | (sums[i] > half ? 1 : 0);
        }

        return maj;
    }
}