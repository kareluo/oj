package problems.p227;

class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        int i = 0, top = -1, otop = -1;
        long[] numbers = new long[s.length()];
        char[] opts = new char[s.length()];
        while (i < s.length()) {
            if (i >= s.length()) break;
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                numbers[++top] = num;
            } else {
                char ch = s.charAt(i);
                if (ch == '+' || ch == '-') {
                    while (otop >= 0) {
                        long b = numbers[top--];
                        long a = numbers[top--];
                        if (opts[otop] == '*') {
                            numbers[++top] = a * b;
                        } else if (opts[otop] == '/') {
                            numbers[++top] = a / b;
                        } else if (opts[otop] == '+') {
                            numbers[++top] = a + b;
                        } else {
                            numbers[++top] = a - b;
                        }
                        otop--;
                    }
                } else {
                    while (otop >= 0 && (opts[otop] == '*' || opts[otop] == '/')) {
                        long b = numbers[top--];
                        long a = numbers[top--];
                        if (opts[otop] == '*') {
                            numbers[++top] = a * b;
                        } else {
                            numbers[++top] = a / b;
                        }
                        otop--;
                    }
                }
                opts[++otop] = ch;
                i++;
            }
        }
        while (otop >= 0) {
            long b = numbers[top--];
            long a = numbers[top--];
            if (opts[otop] == '*') {
                numbers[++top] = a * b;
            } else if (opts[otop] == '/') {
                numbers[++top] = a / b;
            } else if (opts[otop] == '+') {
                numbers[++top] = a + b;
            } else {
                numbers[++top] = a - b;
            }
            otop--;
        }
        return (int) numbers[0];
    }
}