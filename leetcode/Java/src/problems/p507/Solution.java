package problems.p507;

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        int sum = 1, sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += num / i + i;
            }
        }
        if (sqrt * sqrt == num) sum -= sqrt;
        return sum == num;
    }
}