package problems.p859;

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] as = A.toCharArray();
        char[] bs = B.toCharArray();
        int i = 0, j = as.length - 1;
        while (i <= j && as[i] == bs[i]) i++;
        while (j >= i && as[j] == bs[j]) j--;

        if (i < j) {
            if (as[i] != bs[j] || as[j] != bs[i]) {
                return false;
            }
            i++;
            j--;
            while (i <= j) {
                if (as[i] != bs[i]) {
                    return false;
                }
                i++;
            }
            return true;
        } else {
            if (i == j) return false;
            if (as.length > 26) {
                return true;
            } else {
                for (i = 0; i < as.length; i++) {
                    for (j = i + 1; j < as.length; j++) {
                        if (as[i] == as[j]) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
    }
}