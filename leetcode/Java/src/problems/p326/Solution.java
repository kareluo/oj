package problems.p326;

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1 || (n >= 3 && n % 3 == 0 && (n - 1) % 2 == 0)) {
            while (n % 3 == 0) {
                n /= 3;
            }
            return n == 1;
        }
        return false;
    }
}