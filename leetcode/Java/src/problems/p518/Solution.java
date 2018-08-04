package problems.p518;

class Solution {
    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];

        f[0] = 1;
        for (int coin : coins)
            for (int j = coin; j <= amount; j++)
                f[j] += f[j - coin];

        return f[amount];
    }
}