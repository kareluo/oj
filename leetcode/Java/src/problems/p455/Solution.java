package problems.p455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int children = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && g[i] > s[j]) j++;
            if (j < s.length) {
                children++;
            } else break;
        }
        return children;
    }
}