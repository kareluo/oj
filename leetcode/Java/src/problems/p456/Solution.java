package problems.p456;

class Solution {
    public boolean find132pattern(int[] nums) {
        int top = -1, two = Integer.MIN_VALUE;
        int[] stack = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > two) {
                while (top >= 0 && nums[i] > stack[top]) {
                    two = stack[top--];
                }
                stack[++top] = nums[i];
            } else if (nums[i] < two) {
                return true;
            }
        }
        return false;
    }
}