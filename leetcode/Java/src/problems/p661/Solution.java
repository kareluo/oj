package problems.p661;

class Solution {

    private static final int[] drow = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};

    private static final int[] dcol = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};

    public int[][] imageSmoother(int[][] M) {
        int rows = M.length, cols = M[0].length;

        int[][] m = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int gray = M[i][j], cells = 1;
                for (int k = 0; k < 8; k++) {
                    int row = i + drow[k], col = j + dcol[k];
                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        gray += M[row][col];
                        cells++;
                    }
                }
                m[i][j] = gray / cells;
            }
        }

        return m;
    }
}