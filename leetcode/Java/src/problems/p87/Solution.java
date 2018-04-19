package problems.p87;

class Solution {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length() || s1.isEmpty()) {
            return false;
        }

        int[][] ss1 = new int[s1.length()][s1.length()];
        int[][] ss2 = new int[s2.length()][s2.length()];

        ss1[0][0] = s1.charAt(0);
        for (int i = 1; i < s1.length(); i++) {
            ss1[0][i] = ss1[0][i - 1] + s1.charAt(i);
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {
                ss1[i][j] = ss1[0][j] - ss1[0][i - 1];
            }
        }

        ss2[0][0] = s2.charAt(0);
        for (int i = 1; i < s2.length(); i++) {
            ss2[0][i] = ss2[0][i - 1] + s2.charAt(i);
        }

        for (int i = 1; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                ss2[i][j] = ss2[0][j] - ss2[0][i - 1];
            }
        }

        return isScrambleArray(ss1, ss2, 0, s1.length() - 1, 0, s2.length() - 1);
    }

    private boolean isScrambleArray(int[][] sa, int[][] sb, int startA, int endA, int startB, int endB) {
        if (sa[startA][endA] != sb[startB][endB]) return false;
        if (startA == endA) return true;

        for (int i = 0; i < endA - startA; i++) {
            if (isScrambleArray(sa, sb, startA, startA + i, startB, startB + i)
                    && isScrambleArray(sa, sb, startA + i + 1, endA, startB + i + 1, endB)) {
                return true;
            }

            if (isScrambleArray(sa, sb, startA, startA + i, endB - i, endB)
                    && isScrambleArray(sa, sb, startA + i + 1, endA, startB, endB - i - 1)) {
                return true;
            }
        }
        return false;
    }
}