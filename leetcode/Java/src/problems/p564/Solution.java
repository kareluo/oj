package problems.p564;

class Solution {

    public String nearestPalindromic(String n) {
        int length = n.length(), last = length - 1;
        int[] numbers = new int[length];
        long number = 0, change = 0, unit = 1;
        for (int i = 0; i < length; i++) {
            numbers[i] = n.charAt(i) - '0';
            number = number * 10 + numbers[i];
            unit *= 10;
        }

        StringBuilder sb = new StringBuilder(length);
        sb.setLength(length);

        int ut = 1;
        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            if (numbers[i] != numbers[j]) {
                change = change + (numbers[i] - numbers[j]) * ut;
            }
            sb.setCharAt(i, (char) (numbers[i] + '0'));
            sb.setCharAt(j, (char) (numbers[i] + '0'));
            ut *= 10;
        }

        ut /= 10;
        if (change == 0) {
            char ch;
            if (numbers[length >> 1] == 0) {
                ch = '1';
                change += ut;
                sb.setCharAt(length >> 1, ch);
            } else {
                ch = (char) (numbers[length >> 1] - 1 + '0');
                change -= ut;
                sb.setCharAt(length >> 1, ch);
            }

            if ((length & 1) == 0) {
                change = change * 10 + change;
                sb.setCharAt((length >> 1) - 1, ch);
            }
        }

        if (numbers[0] == 1 && length > 1) {
            if (number % (unit / 10) + 1 <= Math.abs(change)) {
                StringBuilder s = new StringBuilder(length - 1);
                for (int i = 1; i < length; i++) {
                    s.append("9");
                }
                return s.toString();
            }
        }

        if (numbers[0] == 9) {
            if (unit - number + 1 < Math.abs(change)) {
                StringBuilder s = new StringBuilder(length + 1);
                s.append("1");
                for (int i = 1; i < length; i++) {
                    s.append("0");
                }
                s.append("1");
                return s.toString();
            }
        }

        return sb.toString();
    }

}