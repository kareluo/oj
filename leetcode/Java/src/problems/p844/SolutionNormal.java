package problems.p844;

class SolutionNormal {
    public boolean backspaceCompare(String S, String T) {
        int topS = -1, topT = -1;
        char[] stackS = new char[S.length()];
        char[] stackT = new char[T.length()];
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stackS[++topS] = S.charAt(i);
            } else {
                if (topS >= 0) topS--;
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                stackT[++topT] = T.charAt(i);
            } else {
                if (topT >= 0) topT--;
            }
        }
        if (topS != topT) return false;
        for (int i = 0; i < topS; i++) {
            if (stackS[i] != stackT[i]) {
                return false;
            }
        }
        return true;
    }
}