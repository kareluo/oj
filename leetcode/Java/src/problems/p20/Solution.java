package problems.p20;

class Solution {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int top = -1;
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++top] = ch;
                if (top >= chars.length >> 1) {
                    return false;
                }
            } else {
                if (top < 0) return false;
                if (ch == ')' && stack[top--] != '('
                        || ch == ']' && stack[top--] != '['
                        || ch == '}' && stack[top--] != '{') {
                    return false;
                }
            }
        }
        return top < 0;
    }
}