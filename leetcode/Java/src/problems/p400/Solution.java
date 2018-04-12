package problems.p400;

class Solution {

    public int findNthDigit(int n) {
        for (long i = 1, scale = 9; ; i++, scale *= 10) {
            if (n > scale * i) {
                n -= scale * i;
            } else {
                scale /= 9;
                long step = n / i + scale - 1;
                if (n % i == 0) {
                    return (int) (step % 10);
                } else {
                    step++;
                    for (long j = n % i; j > 1; j--) {
                        scale /= 10;
                    }
                    return (int) (step / scale % 10);
                }
            }
        }
    }
}