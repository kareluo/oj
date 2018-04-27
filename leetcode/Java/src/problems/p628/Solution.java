package problems.p628;

class Solution {
    public int maximumProduct(int[] nums) {
        int[] maximums = new int[]{-1000, -1000, -1000};
        int[] minimums = new int[]{1000, 1000, 1000};

        for (int num : nums) {
            if (num >= maximums[0]) {
                maximums[2] = maximums[1];
                maximums[1] = maximums[0];
                maximums[0] = num;
            } else if (num >= maximums[1]) {
                maximums[2] = maximums[1];
                maximums[1] = num;
            } else if (num > maximums[2]) {
                maximums[2] = num;
            }

            if (num <= minimums[0]) {
                minimums[2] = minimums[1];
                minimums[1] = minimums[0];
                minimums[0] = num;
            } else if (num <= minimums[1]) {
                minimums[2] = minimums[1];
                minimums[1] = num;
            } else if (num < minimums[2]) {
                minimums[2] = num;
            }
        }

        int product = maximums[0] * maximums[1] * maximums[2];
        if (minimums[0] * minimums[1] * maximums[0] > product) {
            product = minimums[0] * minimums[1] * maximums[0];
        }

        return product;
    }
}