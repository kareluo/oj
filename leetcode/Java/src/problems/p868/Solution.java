package problems.p868;

class Solution {
    public int binaryGap(int N) {
        int i = 0, previous = -1, max = 0;
        while (N > 0) {
            if ((N & 1) == 1) {
                if (previous >= 0) {
                    max = Math.max(max, i - previous);
                }
                previous = i;
            }
            N >>= 1;
            i++;
        }
        return max;
    }
}