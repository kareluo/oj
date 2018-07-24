package problems.p733;

class Solution {

    private static final int[] dCols = {0, 1, 0, -1};

    private static final int[] dRows = {-1, 0, 1, 0};

    private int rows, cols;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        rows = image.length;
        if (rows == 0) return image;
        cols = image[0].length;
        if (cols == 0) return image;

        if (inside(sr, sc) && image[sr][sc] != newColor) {
            fill(image, sr, sc, newColor, image[sr][sc]);
        }

        return image;
    }

    private void fill(int[][] image, int row, int col, int color, int targetColor) {
        image[row][col] = color;
        for (int i = 0; i < 4; i++) {
            int newRow = row + dRows[i], newCol = col + dCols[i];
            if (inside(newRow, newCol) && image[newRow][newCol] == targetColor) {
                fill(image, newRow, newCol, color, targetColor);
            }
        }
    }

    private boolean inside(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}