package problems.p696;

class Solution {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int pn = 0, n = 0, ans = 0;
        char ch = 'x';
        for (char c : chars) {
            if (c == ch) {
                n++;
            } else {
                ch = c;
                ans += Math.min(pn, n);
                pn = n;
                n = 1;
            }
        }
        ans += Math.min(pn, n);
        return ans;
    }
}