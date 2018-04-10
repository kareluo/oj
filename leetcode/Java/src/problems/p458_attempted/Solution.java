package problems.p458_attempted;

class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie;
        if ((1 << n) >= buckets) {
            return 2 * n > buckets ? buckets : 2 * n;
        } else {
            int bn = 1 << (n - 1);
            return 2 * (n - 1) + buckets / bn + ((buckets % bn != 0) ? 1 : 0);
        }
    }
}