package problems.p528;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int sum = 0;

    private int[] sums;

    private int pre, preIndex;

    private Random random = new Random();

    public Solution(int[] w) {
        sums = new int[w.length];
        if (w.length > 0) {
            sums[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                sums[i] = w[i] + sums[i - 1];
            }
            sum = sums[w.length - 1];
            pre = sum;
            preIndex = w.length - 1;
        }
    }

    public int pickIndex() {
        int s = random.nextInt(sum) + 1;
        int i;
        if (s > pre) {
            i = Arrays.binarySearch(sums, preIndex, sums.length, s);
        } else if (s < pre) {
            i = Arrays.binarySearch(sums, 0, preIndex + 1, s);
        } else {
            return preIndex;
        }
        if (i < 0) i = -i - 1;
        pre = s;
        preIndex = i;
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */