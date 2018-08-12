package problems.p525;

class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] digits = new int[2];
        digits[nums[0]]++;
        int diff = digits[0] - digits[1], len = 0;
        int[] indexes = new int[(nums.length << 1) + 1];
        for (int i = 1, k; i < nums.length; i++) {
            digits[nums[i]]++;
            k = digits[0] - digits[1];
            if (k == 0) {
                len = i + 1;
            } else if (k == diff) {
                len = i;
            } else {
                k += nums.length;
                if (indexes[k] != 0) {
                    len = Math.max(len, i - indexes[k]);
                } else {
                    indexes[k] = i;
                }
            }
        }
        return len;
    }
}