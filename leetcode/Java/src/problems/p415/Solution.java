package problems.p415;

class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() > num2.length()) {
            return addStrings(num2, num1);
        }

        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        char[] chars = new char[num2.length() + 1];
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        while (i >= 0) {
            carry += chars1[i] + chars2[j] - 96;
            chars[j + 1] = (char) (carry % 10 + '0');
            carry /= 10;
            i--;
            j--;
        }

        while (j >= 0) {
            carry += chars2[j] - 48;
            chars[j + 1] = (char) (carry % 10 + '0');
            carry /= 10;
            j--;
        }

        if (carry > 0) {
            chars[0] = (char) (carry + '0');
            return new String(chars);
        }

        return new String(chars, 1, chars2.length);
    }
}