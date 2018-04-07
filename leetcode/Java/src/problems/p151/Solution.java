package problems.p151;

class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder(s.length() + 1);
        int i = s.length() - 1, j = s.length();
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i + 1 < j) {
                    sb.append(s.substring(i + 1, j)).append(" ");
                }
                j = i;
            }
        }
        return sb.append(s.substring(0, j)).toString();
    }
}