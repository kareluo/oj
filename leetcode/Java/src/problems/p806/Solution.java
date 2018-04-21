package problems.p806;

class Solution {

    public int[] numberOfLines(int[] widths, String S) {
        int lines = S.isEmpty() ? 0 : 1, space = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (widths[ch - 'a'] + space > 100) {
                lines++;
                space = widths[ch - 'a'];
            } else {
                space += widths[ch - 'a'];
            }
        }
        return new int[]{lines, space};
    }
}