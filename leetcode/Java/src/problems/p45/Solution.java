package problems.p45;

class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 0, a = 0, b = 0, last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > a) {
                step++;
                a = b;
            }
            if (i <= a) {
                b = Math.max(b, nums[i] + i);
                if (b >= last) {
                    return step + 1;
                }
            }
        }
        return step;
    }
}