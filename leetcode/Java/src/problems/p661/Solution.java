package problems.p661;

// TODO
class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return M;
        int[][] m = new int[M.length][M[0].length];
        int[][] ss = new int[M.length][M[0].length];
        int[] s = new int[M[0].length];
        for (int i = 0; i < M.length; i++) {
            int line = 0;
            for (int j = 0; j < M[i].length; j++) {
                line += M[i][j];
                s[j] += line;
                ss[i][j] = s[j];
            }
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int maxi = Math.min(M.length - 1, i + 1);
                int maxj = Math.min(M[i].length - 1, j + 1);
                int mini = i - 2, minj = j - 2;
                m[i][j] = ss[maxi][maxj];
                if (mini >= 0 && minj >= 0) {
                    m[i][j] = ss[maxi][maxj] - ss[mini][maxj] - ss[maxi][minj] + ss[mini][minj];
                } else if (mini >= 0) {
                    m[i][j] = ss[maxi][maxj] - ss[mini][maxj] - ss[maxi][minj] + ss[mini][minj];
                } else if (minj >= 0) {
                    m[i][j] = ss[maxi][maxj] - ss[mini][maxj] - ss[maxi][minj] + ss[mini][minj];
                } else {
                    m[i][j] = ss[maxi][maxj] - ss[mini][maxj] - ss[maxi][minj] + ss[mini][minj];
                }


                m[i][j] = (-ss[mini][maxj] - ss[maxi][minj] + ss[mini][minj]) / ((maxi - mini) * (maxj - minj));
            }
        }

        return m;
    }
}