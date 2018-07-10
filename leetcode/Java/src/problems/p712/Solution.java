package problems.p712;

class Solution {

    public int minimumDeleteSum(String s1, String s2) {
        if (s1.isEmpty() && s2.isEmpty()) return 0;
        if (s2.isEmpty()) return minimumDeleteSum(s2, s1);
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        if (s1.isEmpty()) {
            int sum = 0;
            for (char ch : chs2) {
                sum += ch;
            }
            return sum;
        }
        int[][] f = new int[chs1.length + 1][chs2.length + 1];
        f[0][0] = 0;

        for (int i = 1; i <= chs1.length; i++) {
            f[i][0] = f[i - 1][0] + chs1[i - 1];
        }

        for (int j = 1; j <= chs2.length; j++) {
            f[0][j] = f[0][j - 1] + chs2[j - 1];
        }

        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                f[i][j] = Math.min(f[i][j - 1] + chs2[j - 1], f[i - 1][j] + chs1[i - 1]);
                if (chs1[i - 1] == chs2[j - 1] && f[i - 1][j - 1] < f[i][j]) {
                    f[i][j] = f[i - 1][j - 1];
                }
            }
        }
        return f[chs1.length][chs2.length];
    }
}