package problems.p191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            count += (n >> i) & 1;
        }
        return count;
    }
}