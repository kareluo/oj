package problems.p633;

class Solution {

    public boolean judgeSquareSum(int c) {
        int limit = (int) Math.floor(Math.sqrt(c / 2));
        for (int i = 0; i <= limit; i++) {
            int s = sqrt(c - i * i);
            if (s * s + i * i == c) {
                return true;
            }
        }
        return false;
    }

    private int sqrt(int num) {
        double x = num / 2, y;
        do {
            y = x;
            x = (x + num / x) / 2;
        } while (y - x > 0.1);
        return (int) Math.floor(x);
    }
}