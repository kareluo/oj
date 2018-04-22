package problems.p581;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int begin = -2, end = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
                if (begin == -2) {
                    begin = i - 1;
                }
                while (begin >= 0 && nums[begin] > nums[i]) {
                    begin--;
                }
            } else {
                max = nums[i];
            }
        }
        return end - begin;
    }
}