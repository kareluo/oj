package problems.p3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exists = new boolean[128];
        char[] chars = s.toCharArray();
        int head = 0, len = 0;
        for (int i = 0; i < chars.length; i++) {
            while (exists[chars[i]]) {
                exists[chars[head++]] = false;
            }
            exists[chars[i]] = true;
            if (i - head + 1 > len) {
                len = i - head + 1;
            }
        }
        return len;
    }
}