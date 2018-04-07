package problems.p190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rn = 0;
        for (int i = 32; i != 0; i--, rn <<= 1, rn |= n & 1, n >>>= 1) ;
        return rn;
    }
}
