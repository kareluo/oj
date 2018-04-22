package problems.p283;

class Solution {
    public void moveZeroes(int[] nums) {
        int i, j;
        for (i = 0; i < nums.length; i++) if (nums[i] == 0) break;
        for (j = 0; j < nums.length; j++) if (nums[j] != 0 && j > i) break;
        while (i < j && j < nums.length) {
            nums[i++] = nums[j];
            nums[j++] = 0;
            while (i < nums.length && nums[i] != 0) i++;
            while (j < nums.length && nums[j] == 0) j++;
        }
    }
}