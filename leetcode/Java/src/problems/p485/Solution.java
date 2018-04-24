package problems.p485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maximum = 0;

        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 1) {
                count++;
                i++;
            } else {
                if (count > maximum) maximum = count;
                for (; i < nums.length; i++) {
                    if (nums[i] != 0) break;
                }
                if (i + maximum >= nums.length || nums[i + maximum] == 0) {
                    i += maximum + 1;
                }
                count = 0;
            }
        }

        return Math.max(count, maximum);
    }
}