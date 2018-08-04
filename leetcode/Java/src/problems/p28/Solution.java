package problems.p28;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        char[] ts = haystack.toCharArray();
        char[] ps = needle.toCharArray();

        int[] next = getNext(ps);

        int i = 0, j = 0;
        while (i < ts.length && j < ps.length) {
            if (j == -1 || ts[i] == ps[j]) {
                i++;
                j++;
            } else j = next[j];
        }

        if (j >= ps.length) {
            return i - ps.length;
        }

        return -1;
    }

    private int[] getNext(char[] ps) {
        int[] next = new int[ps.length + 1];
        next[0] = -1;
        int k = -1, i = 0;
        while (i < ps.length) {
            if (k == -1 || ps[k] == ps[i]) {
                next[++i] = ++k;
            } else k = next[k];
        }
        return next;
    }
}