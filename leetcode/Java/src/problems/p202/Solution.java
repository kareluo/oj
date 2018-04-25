package problems.p202;

class Solution {
    public boolean isHappy(int n) {
        if (n < 1) return false;
        int m, nn;
        boolean[] v = new boolean[810];
        while (n != 1) {
            m = 0;
            while (n > 0) {
                nn = n % 10;
                nn *= nn;
                m += nn;
                n /= 10;
            }
            n = m;
            if (v[n]) break;
            v[n] = true;
        }
        return n == 1;
    }
}