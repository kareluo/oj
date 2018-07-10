package problems.p840;

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        boolean[][] v = new boolean[row / 3 + 1][col / 3 + 1];
        row -= 2;
        col -= 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int visit = 0, rows = 0, cols = 0;
                boolean abort = false;
                for (int ii = i; ii < i + 3; ii++) {
                    rows = 0;
                    for (int jj = j; jj < j + 3; jj++) {
                        if ((visit & (1 << grid[ii][jj])) != 0) {
                            abort = true;
                            break;
                        }
                        visit |= 1 << grid[ii][jj];
                        rows += grid[ii][jj];
                    }
                    if (abort) break;
                    if (rows != 15) {
                        abort = true;
                        break;
                    }
                }
                if (abort || visit != 1022) continue;
                for (int jj = j; jj < j + 3; jj++) {
                    cols = 0;
                    for (int ii = i; ii < i + 3; ii++) {
                        cols += grid[ii][jj];
                    }
                    if (cols != 15) {
                        abort = true;
                        break;
                    }
                }
                if (abort) continue;
                abort = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15;
                abort |= grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15;
                v[i / 3][j / 3] |= !abort;
            }
        }
        int count = 0;
        for (boolean[] aV : v) {
            for (boolean anAV : aV) {
                if (anAV) count++;
            }
        }
        return count;
    }
}