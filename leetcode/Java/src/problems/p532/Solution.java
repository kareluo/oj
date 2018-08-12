package problems.p532;

import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Arrays.sort(nums);
        int pairs = 0;
        for (int i = 0, j = 0; j < nums.length; i++) {
            int target = nums[i] + k;
            while (j < nums.length && (nums[j] < target || j <= i)) j++;
            if (j < nums.length && nums[j] == target) {
                pairs++;
                while (j < nums.length && nums[j] == target) j++;
            }
        }
        return pairs;
    }
}