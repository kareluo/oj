package problems.p413;

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0, p = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                sum += p + 1;
                p++;
            } else {
                p = 0;
            }
        }
        return sum;
    }
}