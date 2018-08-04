package problems.p504;

class Solution {
    public String convertToBase7(int num) {
        String flag = "";
        if (num < 0) {
            num = -num;
            flag = "-";
        }

        char[] numbers = new char[12];

        int index = 0;
        do {
            numbers[index++] = (char) (num % 7 + '0');
            num /= 7;
        } while (num > 0);

        for (int i = 0, j = index - 1; i < j; i++, j--) {
            numbers[i] ^= numbers[j];
            numbers[j] ^= numbers[i];
            numbers[i] ^= numbers[j];
        }

        return flag + String.valueOf(numbers, 0, index);
    }
}