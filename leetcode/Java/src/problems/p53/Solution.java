package problems.p53;

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num;
            if (sum > max) max = sum;
        }
        return max;
    }
}