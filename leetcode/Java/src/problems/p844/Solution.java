package problems.p844;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sShape = 0, tShape = 0;
        int i = S.length() - 1, j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    sShape++;
                } else if (sShape > 0) {
                    sShape--;
                } else break;
                i--;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    tShape++;
                } else if (tShape > 0) {
                    tShape--;
                } else break;
                j--;
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else if (i < 0 && j >= 0 || i >= 0) {
                return false;
            }
        }
        return true;
    }
}
