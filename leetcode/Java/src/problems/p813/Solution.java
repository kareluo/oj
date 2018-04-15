package problems.p813;

class Solution {

    public double largestSumOfAverages(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }

        double[] sumA = new double[A.length];
        sumA[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sumA[i] = sumA[i - 1] + A[i];
        }

        double[][] f = new double[A.length][K + 1];

        for (int i = 0; i < A.length; i++) {
            f[i][1] = sumA[i] / (i + 1);
        }
        for (int k = 2; k <= K; k++) {
            for (int i = k - 1; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                    f[i][k] = Math.max(f[i][k], f[j][k - 1] + (sumA[i] - sumA[j]) / (i - j));
                }
            }
        }

        return f[A.length - 1][K];
    }
}