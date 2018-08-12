package problems.p397;

class Solution {
    public int integerReplacement(int n) {
        int opts = 0;
        while (n > 1) {
            while ((n & 1) == 0) {
                n >>= 1;
                opts++;
            }
            if (n == 1) break;
            if (n == 3) {
                opts += 2;
                break;
            }
            int one = 0;
            while ((n & 1) == 1) {
                n >>= 1;
                one++;
            }
            if (one == 1) {
                n <<= 1;
                opts++;
            } else {
                n |= 1;
                opts += one + 1;
            }
        }
        return opts;
    }
}