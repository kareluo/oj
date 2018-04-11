package problems.p338;

class Solution {

    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        for (int i = 0; i <= (num - 1) >> 1; i++) {
            results[i << 1] = results[i];
            results[(i << 1) | 1] = results[i] + 1;
        }

        if ((num & 1) == 0) {
            results[num] = results[num >> 1];
        }

        return results;
    }
}

class Solution2 {

    public int[] countBits(int num) {
        int[] results = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            results[i] = results[i >> 1] + (i & 1);
        }
        return results;
    }
}