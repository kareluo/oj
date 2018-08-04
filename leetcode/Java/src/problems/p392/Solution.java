package problems.p392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        int j = 0;
        for (int i = 0; i < ts.length && j < ss.length; i++) {
            if (ts[i] == ss[j]) j++;
        }
        return j >= ss.length;
    }
}