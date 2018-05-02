package problems.p326;

class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && n % 3 == 0 && ((n - 1) % 4 == 0 || (n + 1) % 4 == 0);
    }
}