package problems.p605;

class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count, empty = 0, i = 0;
        for (; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) break;
            empty++;
        }

        if (empty == flowerbed.length) {
            count = (empty + 1) >> 1;
        } else {
            count = empty >> 1;
            for (empty = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 1) {
                    if (empty > 0) {
                        count += (empty - 1) >> 1;
                    }
                    empty = 0;
                    continue;
                }
                empty++;
            }

            if (empty > 0) {
                count += empty >> 1;
            }
        }

        return n <= count;
    }
}