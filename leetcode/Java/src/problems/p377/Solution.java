package problems.p377;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] sum = new int[target + 1];
        sum[0] = 1;
        for (int i = 1; i <= target; i++) {
            if (sum[i] <= 0) continue;
            for (int num : nums) {
                if (i + num <= target) {
                    sum[i + num] += sum[i];
                }
            }
        }
        return sum[target];
    }
}