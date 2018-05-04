package problems.p67;

class Solution {
    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            return addBinary(b, a);
        }

        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();

        char[] cs = new char[b.length() + 1];

        char c = '0';
        int i = as.length - 1, j = bs.length - 1;
        for (; i >= 0; i--, j--) {
            if (as[i] == '1') {
                if (bs[j] == '1') {
                    cs[j + 1] = c;
                    c = '1';
                } else {
                    if (c == '1') {
                        cs[j + 1] = '0';
                    } else {
                        cs[j + 1] = '1';
                    }
                }
            } else {
                if (bs[j] == '1') {
                    if (c == '1') {
                        cs[j + 1] = '0';
                    } else {
                        cs[j + 1] = '1';
                    }
                } else {
                    cs[j + 1] = c;
                    c = '0';
                }
            }
        }

        while (j >= 0) {
            if (bs[j] == '1') {
                if (c == '1') {
                    cs[j + 1] = '0';
                } else {
                    cs[j + 1] = '1';
                }
            } else {
                if (c == '1') {
                    cs[j + 1] = '1';
                    c = '0';
                } else {
                    cs[j + 1] = '0';
                }
            }
            j--;
        }

        if (c == '1') {
            cs[0] = '1';
            return String.valueOf(cs);
        }

        return String.valueOf(cs, 1, bs.length);
    }
}