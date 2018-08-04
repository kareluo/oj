package problems.p407;

import java.util.*;

class Solution {

    private int rows, cols;

    private int volume = 0;

    private int[][] heights;

    private Queue<Cell> cells = new PriorityQueue<>();

    private static final int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        heights = heightMap;

        rows = heightMap.length;
        cols = heightMap[0].length;

        boolean[][] visit = new boolean[rows][cols];

        volume = 0;
        cells.clear();

        for (int i = 0, last = cols - 1; i < rows; i++) {
            cells.offer(new Cell(i, 0, heightMap[i][0]));
            cells.offer(new Cell(i, last, heightMap[i][last]));
        }

        for (int i = cols - 1, last = rows - 1; i > 0; i--) {
            cells.offer(new Cell(0, i, heightMap[0][i]));
            cells.offer(new Cell(last, i, heightMap[last][i]));
        }

        while (!cells.isEmpty()) {
            Cell cell = cells.poll();
            if (!visit[cell.row][cell.col]) {
                fill(visit, cell.row, cell.col, cell.height);
            }
        }

        return volume;
    }

    private void fill(boolean[][] visit, int row, int col, int top) {
        visit[row][col] = true;
        volume += top - heights[row][col];
        for (int i = 0; i < 4; i++) {
            int nRow = row + drc[i][0];
            int nCol = col + drc[i][1];
            if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && !visit[nRow][nCol]) {
                if (heights[nRow][nCol] <= top) {
                    fill(visit, nRow, nCol, top);
                } else {
                    cells.offer(new Cell(nRow, nCol, heights[nRow][nCol]));
                }
            }
        }
    }

    private static class Cell implements Comparable<Cell> {

        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
}