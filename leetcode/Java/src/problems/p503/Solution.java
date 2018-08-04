package problems.p503;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0) return nums;
        int top = -1;
        int[] stack = new int[nums.length];
        int[] indexes = new int[nums.length];
        int[] elements = new int[nums.length];
        stack[++top] = nums[0];
        indexes[top] = 0;
        for (int i = 1; i < nums.length; i++) {
            while (top >= 0 && nums[i] > stack[top]) {
                elements[indexes[top]] = nums[i];
                top--;
            }
            stack[++top] = nums[i];
            indexes[top] = i;
        }
        for (int num : nums) {
            while (top >= 0 && num > stack[top]) {
                elements[indexes[top]] = num;
                top--;
            }
            if (stack[0] == stack[top]) {
                while (top >= 0) elements[indexes[top--]] = -1;
                break;
            }
        }
        return elements;
    }
}