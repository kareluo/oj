package problems.p42;

class Solution {
    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int top = -1, volume = 0;
        int[] stack = new int[height.length];
        int left = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= left) {
                while (top >= 0) {
                    volume += left - stack[top--];
                }
                left = height[i];
            } else stack[++top] = height[i];
        }
        if (top > 0) {
            int right = stack[top--];
            while (top >= 0) {
                if (stack[top] > right) {
                    right = stack[top];
                }
                volume += right - stack[top--];
            }
        }
        return volume;
    }
}