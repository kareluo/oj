package problems.p31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) return;
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                int that = index + 1;
                for (int i = that + 1; i < nums.length; i++) {
                    if (nums[i] > nums[index] && nums[i] < nums[that]) {
                        that = i;
                    }
                }
                nums[index] ^= nums[that];
                nums[that] ^= nums[index];
                nums[index] ^= nums[that];
                break;
            }
            index--;
        }
        Arrays.sort(nums, index + 1, nums.length);
    }
}