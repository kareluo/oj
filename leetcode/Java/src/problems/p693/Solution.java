package problems.p693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        return (n & 0x55555555) == n || (n & 0x2AAAAAAA) == n;
    }
}