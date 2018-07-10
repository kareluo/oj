package problems.p598;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for (int[] op : ops) {
            if (row > op[0]) {
                row = op[0];
            }
            if (col > op[1]) {
                col = op[1];
            }
        }
        return row * col;
    }
}