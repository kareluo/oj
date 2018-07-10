package problems.p832;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0, t; i < A.length; i++) {
            for (int j = 0, k = A[i].length - 1; j <= k; j++, k--) {
                t = A[i][j] ^ 1;
                A[i][j] = A[i][k] ^ 1;
                A[i][k] = t;
            }
        }
        return A;
    }
}