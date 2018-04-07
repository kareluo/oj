package problems.p461;

class Solution {

    public int hammingDistance(int x, int y) {
        int n = 0, xy = x ^ y;
        for (int i = 32; i > 0; i--) {
            n += xy & 1;
            xy >>>= 1;
        }
        return n;
    }
}
