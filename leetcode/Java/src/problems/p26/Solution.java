package problems.p26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == nums[j - 1]) j++;
            if (j < nums.length) {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }
}