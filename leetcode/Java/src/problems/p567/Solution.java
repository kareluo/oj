package problems.p567;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int head = 0, tail = 0;
        char[] queue = new char[Math.max(s1.length(), s2.length())];
        int[] chs = new int[128];
        int[] indicates = new int[128];
        for (char ch : s1.toCharArray()) {
            chs[ch]++;
        }
        for (char ch : s2.toCharArray()) {
            if (chs[ch] == 0) {
                if (tail > 0) {
                    Arrays.fill(indicates, 'a', 'z' + 1, 0);
                }
                head = tail = 0;
            } else {
                while (indicates[ch] >= chs[ch]) {
                    indicates[queue[head++]]--;
                }
                indicates[ch]++;
                queue[tail++] = ch;
                if (tail - head == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}