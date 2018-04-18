package problems.p665;

class Solution {

    public boolean checkPossibility(int[] nums) {
        for (int i = 1, count = 0; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (count > 0) return false;

                int pre = nums[i - 1];
                // 前一个改小
                if (i > 1) {
                    nums[i - 1] = nums[i - 2];
                } else {
                    nums[i - 1] = Integer.MIN_VALUE;
                }

                int cur = nums[i];
                if (nums[i] < nums[i - 1]) {
                    nums[i - 1] = pre;
                    // 当前个改大
                    if (i < nums.length - 1) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i] = Integer.MAX_VALUE;
                    }
                }

                if (nums[i] < nums[i - 1]) return false;

                count++;
            }
        }
        return true;
    }
}