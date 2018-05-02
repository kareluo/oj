package problems.p409;

class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[127];
        char[] chars = s.toCharArray();
        for (char ch : chars) letters[ch]++;

        int length = 0;
        for (int i = 'a'; i <= 'z'; i++) length += letters[i] >> 1;
        for (int i = 'A'; i <= 'Z'; i++) length += letters[i] >> 1;

        length <<= 1;
        if (length != chars.length) length++;

        return length;
    }
}