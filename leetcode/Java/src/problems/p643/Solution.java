package problems.p643;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i = 0, j, sum = 0, max;
        while (i < k) sum += nums[i++];

        j = 0;
        max = sum;
        while (i < nums.length) {
            sum = sum - nums[j++] + nums[i++];
            if (sum > max) {
                max = sum;
            }
        }
        return 1.0 * max / k;
    }
}