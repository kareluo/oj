package problems.p171;

class Solution {
    public int titleToNumber(String s) {
        int number = 0, step = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            number += (s.charAt(i) - 'A' + 1) * step;
            step *= 26;
        }
        return number;
    }
}