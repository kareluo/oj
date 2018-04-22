package problems.p796;

class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null && B == null) {
            return true;
        }

        if (A == null || B == null) {
            return false;
        }

        if (A.isEmpty() && B.isEmpty()) {
            return true;
        }

        if (A.length() != B.length()) {
            return false;
        }

        int length = A.length();

        for (int i = 0, j, k; i < length; i++) {
            j = 0;
            k = i;
            do {
                if (B.charAt(j++) != A.charAt(k++)) break;
                if (k >= length) k = 0;
            } while (k != i);
            if (k == i) return true;
        }

        return false;
    }
}
