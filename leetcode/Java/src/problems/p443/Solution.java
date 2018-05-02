package problems.p443;

class Solution {
    public int compress(char[] chars) {
        int len = 0, length = 0, i = 0;
        char pch = 0;
        for (char ch : chars) {
            if (pch != ch) {
                if (len == 1) {
                    chars[i++] = pch;
                    length++;
                } else if (len > 1) {
                    chars[i++] = pch;
                    int numLength = addNumber(chars, i, len);
                    i += numLength;
                    length += numLength + 1;
                }
                len = 1;
                pch = ch;
            } else len++;
        }

        if (len == 1) {
            chars[i++] = pch;
            length++;
        } else if (len > 1) {
            chars[i++] = pch;
            int numLength = addNumber(chars, i, len);
            i += numLength;
            length += numLength + 1;
        }

        return length;
    }

    private int addNumber(char[] chars, int i, int num) {
        if (num == 0) return 0;
        int len = addNumber(chars, i, num / 10);
        chars[i + len] = (char) ('0' + num % 10);
        return len + 1;
    }
}