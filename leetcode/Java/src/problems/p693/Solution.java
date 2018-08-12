package problems.p693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        if (isAlternating(n) && isAlternating(n >>> 1)) {
            n |= n >>> 1;
            while (n > 0) {
                if ((n & 1) == 0) {
                    return false;
                }
                n >>>= 1;
            }
            return true;
        }
        return false;
    }

    private boolean isAlternating(int n) {
        return (n & 0x55555555) == n || (n & 0x2AAAAAAA) == n;
    }
}