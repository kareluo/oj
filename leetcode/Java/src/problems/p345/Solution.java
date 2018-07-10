package problems.p345;

class Solution {
    public String reverseVowels(String s) {
        char ch;
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            while (i < j && "aeiouAEIOU".indexOf(chars[i]) < 0) i++;
            while (i < j && "aeiouAEIOU".indexOf(chars[j]) < 0) j--;
            ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }
        return String.valueOf(chars);
    }
}