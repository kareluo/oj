package problems.p575;

class Solution {
    public int distributeCandies(int[] candies) {
        boolean[] v = new boolean[200001];
        int maximum = candies.length >> 1, m = 0;
        for (int candy : candies) {
            if (!v[candy + 100000]) {
                v[candy + 100000] = true;
                if (++m >= maximum) {
                    break;
                }
            }
        }
        return Math.min(m, maximum);
    }
}