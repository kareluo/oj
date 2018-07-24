package problems.p69;

class Solution {
    public int mySqrt(int num) {
        double x = num;
        while (x * x - num > 0.1) {
            x = (x + num / x) / 2;
        }
        return (int) Math.floor(x);
    }
}