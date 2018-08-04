package problems.p792;

import java.util.Arrays;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        char[] ss = S.toCharArray();
        int[] chn = new int[26];
        for (char ch : ss) chn[ch - 97]++;
        int[][] chs = new int[26][];
        for (int i = 0; i < 26; i++) {
            chs[i] = new int[chn[i]];
            chn[i] = 0;
        }
        for (int i = 0; i < ss.length; i++) {
            chs[ss[i] - 97][chn[ss[i] - 97]++] = i;
        }
        int num = 0;
        for (String word : words) {
            int index = 0;
            boolean found = true;
            Arrays.fill(chn, 0);
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 97;
                int pos = Arrays.binarySearch(chs[c], chn[c], chs[c].length, index);
                if (pos < 0) {
                    pos = -pos - 1;
                }
                if (pos < chs[c].length) {
                    chn[c] = pos + 1;
                    index = chs[c][pos] + 1;
                } else {
                    found = false;
                    break;
                }
            }
            if (found) num++;
        }

        return num;
    }
}