package problems.p205;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ato = new int[128];
        int[] bto = new int[128];
        for (int i = 0, a, b; i < s.length(); i++) {
            a = s.charAt(i);
            b = t.charAt(i);
            if (ato[a] == 0) {
                ato[a] = b;
                if (bto[b] != 0) {
                    return false;
                }
                bto[b] = a;
            } else if (ato[a] != b || bto[b] != a) {
                return false;
            }
        }
        return true;
    }
}