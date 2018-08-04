package problems.p556;

import java.util.Arrays;

class Solution {
    public int nextGreaterElement(int n) {
        if (n <= 0) return -1;
        int[] digits = new int[10];
        int m = n, count = 0, digit = 0, max = 0;
        while (m > 0) {
            digit = m % 10;
            m /= 10;
            if (digit >= max) {
                digits[count++] = digit;
                max = digit;
            } else break;
        }

        long ans = m;
        if (digit < max) {
            int next = digits[count - 1], index = count - 1;
            for (int i = 0; i < count; i++) {
                if (digits[i] > digit && digits[i] < next) {
                    next = digits[i];
                    index = i;
                }
            }
            ans = ans * 10 + next;
            digits[index] = digit;
            Arrays.sort(digits, 0, count);
            for (int i = 0; i < count; i++) {
                ans = ans * 10 + digits[i];
            }
        } else return -1;
        return Integer.MAX_VALUE < ans ? -1 : (int) ans;
    }
}