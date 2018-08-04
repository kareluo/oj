package problems.p395;

import java.util.Arrays;

class Solution {
    public int longestSubstring(String s, int k) {
        if (s.isEmpty() || k == 0) {
            return s.length();
        }

        int size = s.length(), length = 0;

        int[] chs = new int[128];

        char[] cs = s.toCharArray();

        for (int i = 0; i < size; i++) {
            chs[cs[i]]++;
        }

        int[] chCounts = new int[128];
        int kn = 0, cn = 0, len = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (chs[cs[i]] < k) {
                if (kn == cn) length = Math.max(length, len);
                len = kn = cn = 0;
                Arrays.fill(chCounts, 97, 123, 0);
            } else {
                len++;
                chCounts[cs[i]]++;
                if (chCounts[cs[i]] == 1) cn++;
                if (chCounts[cs[i]] == k) kn++;
            }
        }

        if (kn == cn) length = Math.max(length, len);

        return length;
    }
}