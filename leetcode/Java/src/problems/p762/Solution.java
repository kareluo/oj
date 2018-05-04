package problems.p762;

class Solution {
    private static final boolean[] isPrime = {
            false, false, true, true, false, true, false, true,
            false, false, false, true, false, true, false, false,
            false, true, false, true, false, false, false, true,
            false, false, false, false, false, true, false, true
    };

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L, j, bits; i <= R; i++) {
            j = i;
            bits = 0;
            while (j > 0) {
                bits += j & 1;
                j >>= 1;
            }
            if (isPrime[bits]) count++;
        }
        return count;
    }
}