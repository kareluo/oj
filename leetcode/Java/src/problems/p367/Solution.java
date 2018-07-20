package problems.p367;

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        long sqrt = Math.round(sqrt(num));
        return sqrt * sqrt == num;
    }

    private double sqrt(int num) {
        double x = num;
        while (x * x - num > 0.5) {
            x = (x + num / x) / 2;
        }
        return x;
    }
}