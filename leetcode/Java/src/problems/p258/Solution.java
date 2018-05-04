package problems.p258;

class Solution {
    public int addDigits(int num) {
        int sum = 0;
        if (num > 0) {
            sum += num % 10 + num / 10 % 10 + num / 100 % 10;
        }
        num /= 1000;
        if (num > 0) {
            sum += num % 10 + num / 10 % 10 + num / 100 % 10;
        }
        num /= 1000;
        if (num > 0) {
            sum += num % 10 + num / 10 % 10 + num / 100 % 10;
        }
        num /= 1000;
        if (num > 0) {
            sum += num;
        }

        if (sum >= 10) {
            sum = sum / 10 + sum % 10;
        }

        if (sum >= 10) {
            sum = sum / 10 + sum % 10;
        }

        return sum;
    }
}