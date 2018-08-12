package problems.p680;

class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return isPalindrome(chars, i + 1, j)
                        || isPalindrome(chars, i, j - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        return i >= j;
    }
}