package problems.p828;

import java.util.Arrays;

class Solution {

    private static final int MOD = 1000000007;

    public int uniqueLetterString(String S) {
        int[] ppos = new int[256];
        int[] pppos = new int[256];
        char[] chars = S.toCharArray();
        Arrays.fill(ppos, -1);
        Arrays.fill(pppos, -1);

        char ch;
        int answer = 0, sum = 0;
        for (int i = 0; i < chars.length; i++) {
            ch = chars[i];
            sum = (sum + i + pppos[ch] - (ppos[ch] << 1)) % MOD;
            answer = (answer + sum) % MOD;
            pppos[ch] = ppos[ch];
            ppos[ch] = i;
        }

        return answer;
    }
}