package problems.p454;

import java.util.Arrays;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;

        if (N == 0) return 0;

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        if (A[0] + B[0] + C[0] + D[0] > 0 || A[N - 1] + B[N - 1] + C[N - 1] + D[N - 1] < 0) {
            return 0;
        }

        int[] AB = new int[N * N];
        int[] CD = new int[N * N];

        int k = 0;
        for (int a : A) {
            for (int b : B) {
                AB[k++] = a + b;
            }
        }

        k = 0;
        for (int c : C) {
            for (int d : D) {
                CD[k++] = -c - d;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int count = 0;
        for (int i = 0, j = 0; i < AB.length && j < CD.length; ) {
            if (AB[i] != CD[j]) {
                if (AB[i] > CD[j]) {
                    j++;
                } else i++;
            } else {
                int v = AB[i];
                int ab = 0, cd = 0;
                while (i < AB.length && v == AB[i]) {
                    i++;
                    ab++;
                }
                while (j < CD.length && v == CD[j]) {
                    j++;
                    cd++;
                }
                count += ab * cd;
            }
        }
        return count;
    }
}
