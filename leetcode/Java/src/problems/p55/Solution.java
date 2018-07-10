package problems.p55;

class Solution {
    public boolean canJump(int[] nums) {
        int arrayIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > arrayIndex) break;
            if (i + nums[i] > arrayIndex) {
                arrayIndex = i + nums[i];
            }
        }
        return arrayIndex >= nums.length - 1;
    }
}