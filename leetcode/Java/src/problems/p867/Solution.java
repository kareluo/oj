package problems.p867;

class Solution {
    public int[][] transpose(int[][] A) {
        if (A.length == 0) return new int[0][0];
        int[][] B = new int[A[0].length][A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = A[i].length - 1; j >= 0; j--) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}