package problems.p97;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        if (s1.length() < s2.length()) {
            return isInterleave(s2, s1, s3);
        }

        if (s2.isEmpty()) return s1.equals(s3);

        int len = s1.length();
        boolean[] f = new boolean[s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s3.charAt(i)) {
                len = i;
                break;
            }
        }

        f[0] = s2.charAt(0) == s3.charAt(0);
        for (int i = 1; i < s2.length(); i++)
            f[i] = f[i - 1] && s2.charAt(i) == s3.charAt(i);

        for (int i = 0; i < s1.length(); i++) {
            f[0] = i < len && s2.charAt(0) == s3.charAt(i + 1) || f[0] && s1.charAt(i) == s3.charAt(i + 1);
            for (int j = 1; j < s2.length(); j++) {
                f[j] = f[j - 1] && s2.charAt(j) == s3.charAt(i + j + 1)
                        || f[j] && s1.charAt(i) == s3.charAt(i + j + 1);
            }
        }

        return f[s2.length() - 1];
    }
}