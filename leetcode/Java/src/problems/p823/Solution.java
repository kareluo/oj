package problems.p823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final int MOD = 1000000007;

    public int numFactoredBinaryTrees(int[] A) {
        Map<Integer, Integer> indexs = new HashMap<>();

        long[] dp = new long[A.length];
        Arrays.sort(A);
        Arrays.fill(dp, 1);

        for (int i = 0; i < A.length; i++) {
            indexs.put(A[i], i);
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int b = A[i] / A[j];
                    Integer k = indexs.get(b);
                    if (k != null) {
                        dp[i] = (dp[i] + dp[j] * dp[k]) % MOD;
                    }
                }
            }
        }

        long sum = 0;
        for (long s : dp) {
            sum = (sum + s) % MOD;
        }

        return (int) sum;
    }
}