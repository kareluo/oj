package problems.p11;

class Solution2 {

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int i = 0, j = height.length - 1, capacity = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if ((j - i) * height[i] > capacity) {
                    capacity = (j - i) * height[i];
                }
                i++;
            } else {
                if ((j - i) * height[j] > capacity) {
                    capacity = (j - i) * height[j];
                }
                j--;
            }
        }

        return capacity;
    }
}