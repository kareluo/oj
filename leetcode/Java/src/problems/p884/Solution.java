package problems.p884;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<String> strings = new ArrayList<>();

    private List<Integer> multiples = new ArrayList<>();

    private String ch;

    public String decodeAtIndex(String S, int K) {

        strings.clear();
        multiples.clear();
        ch = null;

        int len = 0;
        int index = 0, start = 0;
        int multiple = 1;
        boolean isDigit = false;
        while (index < S.length() && len < K) {
            if (isDigit(S.charAt(index))) {
                if (!isDigit) {
                    multiple = 1;
                    strings.add(S.substring(start, index));

                }
                isDigit = true;
                int digit = S.charAt(index) - '0';
                len *= digit;
                multiple = multiple * digit;
            } else {
                if (isDigit) {
                    start = index;
                    multiples.add(multiple);
                }
                isDigit = false;
                len++;
            }
            index++;
        }

        if (isDigit) {
            multiples.add(multiple);
        } else {
            strings.add(S.substring(start, index));
            multiples.add(1);
        }

        getK(0, 0, K);

        return ch;
    }

    private int getK(int len, int index, int K) {
        int group = len + strings.get(index).length();
        int length = group * multiples.get(index);

        int i;
        if (length >= K) {
            i = K % group;
        } else {
            i = getK(length, index + 1, K) % group;
        }

        if (i == 0) {
            i = group;
        }

        if (ch == null) {
            if (i > len) {
                i -= len;
                String s = strings.get(index);
                ch = s.substring(i - 1, i);
            }
        }

        return i;
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}