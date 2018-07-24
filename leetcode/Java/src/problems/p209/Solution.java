package problems.p209;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, len = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (sum >= s) {
                while (sum >= s) {
                    len = j - i + 1;
                    sum -= nums[i++];
                }
            } else if (i > 0) sum -= nums[i++];
        }
        return len;
    }
}