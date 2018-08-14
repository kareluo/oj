package problems.p541;

class Solution {
    public String reverseStr(String s, int k) {
        char ch;
        int k2 = k << 1;
        char[] chars = s.toCharArray();
        for (int index = 0, i, j; index < chars.length; index += k2) {
            i = index;
            j = Math.min(index + k, chars.length) - 1;
            while (i < j) {
                ch = chars[i];
                chars[i++] = chars[j];
                chars[j--] = ch;
            }
        }
        return String.valueOf(chars);
    }
}