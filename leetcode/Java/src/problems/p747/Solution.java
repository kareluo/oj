package problems.p747;

class Solution {
    public int dominantIndex(int[] nums) {
        int first = 0, second = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
                index = i;
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return first >= (second << 1) ? index : -1;
    }
}