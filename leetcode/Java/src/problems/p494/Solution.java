package problems.p494;

class Solution {

    private static final int OFFSET = 20000;

    public int findTargetSumWays(int[] nums, int S) {
        if (S < -OFFSET || S > OFFSET) {
            return 0;
        }

        int p = 0;
        int[][] f = new int[2][(OFFSET << 1) + 1];

        f[0][OFFSET + nums[0]] += 1;
        f[0][OFFSET - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++, p ^= 1) {
            for (int j = -OFFSET; j <= OFFSET; j++) {
                f[p ^ 1][j + OFFSET] = 0;
                if (j >= nums[i] - OFFSET) {
                    f[p ^ 1][j + OFFSET] += f[p][j - nums[i] + OFFSET];
                }
                if (j <= OFFSET - nums[i]) {
                    f[p ^ 1][j + OFFSET] += f[p][j + nums[i] + OFFSET];
                }
            }
        }

        return f[p][S + OFFSET];
    }
}

/*
The best solution of this problem.
refer to https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C++-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation

class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum)>>1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
}
*/