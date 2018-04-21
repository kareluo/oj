package problems.p728;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> nums = new ArrayList<>();
        for (int i = left, j, k; i <= right; ) {
            j = i;
            k = 1;
            while (j > 0) {
                if (j % 10 == 0) {
                    i += k - i % k;
                    break;
                }

                if (i % (j % 10) != 0) {
                    i++;
                    break;
                }

                j /= 10;
                k *= 10;
            }

            if (j == 0) {
                nums.add(i++);
            }
        }
        return nums;
    }

    /**
     * 不优化
     */
    public List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> nums = new ArrayList<>();
        for (int i = left, j; i <= right; i++) {
            for (j = i; j > 0; j /= 10) {
                if (j % 10 == 0 || i % (j % 10) != 0) {
                    break;
                }
            }

            if (j == 0) nums.add(i);
        }
        return nums;
    }
}