package problems.p724;

class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0;
        for (int num : nums) right += num;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            if (left == right) {
                return i;
            }
            right -= nums[i];
        }
        return -1;
    }
}