package problems.p66;

class Solution {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[]{1};
        }
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i - 1] += digits[i] / 10;
                digits[i] %= 10;
            } else break;
        }
        if (digits[0] >= 10) {
            int[] nDigits = new int[digits.length + 1];
            nDigits[0] = digits[0] / 10;
            digits[0] %= 10;
            System.arraycopy(digits, 0, nDigits, 1, digits.length);
            return nDigits;
        }
        return digits;
    }
}