package problems.p557;

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.trim().replaceAll("  +", " ").toCharArray();
        int i, j, k;
        for (i = 0, j = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                k = i - 1;
                while (j < k) {
                    chars[j] ^= chars[k];
                    chars[k] ^= chars[j];
                    chars[j] ^= chars[k];
                    j++;
                    k--;
                }
                j = i + 1;
            }
        }

        k = i - 1;
        while (j < k) {
            chars[j] ^= chars[k];
            chars[k] ^= chars[j];
            chars[j] ^= chars[k];
            j++;
            k--;
        }

        return String.valueOf(chars);
    }
}