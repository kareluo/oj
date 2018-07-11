package problems.p594;

import java.util.Arrays;

class Solution {
    public int findLHS(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int index = 0, len = 0, length = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                if (len > 0 && len + i - index > length) {
                    length = len + i - index;
                }
                if (nums[i] == nums[index] + 1) {
                    len = i - index;
                } else {
                    len = 0;
                }
                index = i;
            }
        }
        if (len > 0 && len + nums.length - index > length) {
            length = len + nums.length - index;
        }
        return length;
    }
}