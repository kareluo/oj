package problems.p459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();

        int i = 0, k = -1;
        int[] next = new int[chars.length + 1];
        next[0] = -1;
        while (i < chars.length) {
            if (k == -1 || chars[i] == chars[k]) {
                next[++i] = ++k;
            } else k = next[k];
        }

        int len = chars.length - next[chars.length];

        return len < chars.length && chars.length % len == 0;
    }
}