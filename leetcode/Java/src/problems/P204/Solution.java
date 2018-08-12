package problems.P204;

class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2, j; i < n; i++) {
            int m = (int) Math.sqrt(i);
            for (j = 2; j <= m; j++) {
                if (i % j == 0) break;
            }
            if (j > m) count++;
        }
        return count;
    }
}