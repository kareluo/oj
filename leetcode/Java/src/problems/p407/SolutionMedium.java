package problems.p407;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionMedium {

    private int rows, cols;

    private Cell[][] cellMap = new Cell[111][111];

    private static final int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        rows = heightMap.length;
        cols = heightMap[0].length;

        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            boolean bank = i == 0 || i == rows - 1;
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j, heightMap[i][j]);
                cell.bank = bank || j == 0 || j == cols - 1;
                cells.add(cell);
                cellMap[i][j] = cell;
            }
        }

        Collections.sort(cells);

        for (Cell cell : cells) {
            if (!cell.inundate && cell.bank) {
                fill(cell, cell.height);
            }
        }

        int volume = 0;
        for (Cell cell : cells) {
            volume += cell.top - cell.height;
        }

        return volume;
    }

    private void fill(Cell cell, int top) {
        cell.inundate = true;
        cell.top = top;
        for (int i = 0; i < 4; i++) {
            Cell nextCell = getCell(cell, i);
            if (nextCell != null && !nextCell.inundate) {
                if (nextCell.height <= top) {
                    fill(nextCell, top);
                } else {
                    nextCell.bank = true;
                }
            }
        }
    }

    private Cell getCell(Cell cell, int index) {
        int row = cell.row + drc[index][0];
        int col = cell.col + drc[index][1];
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return cellMap[row][col];
        }
        return null;
    }

    private static class Cell implements Comparable<Cell> {

        boolean inundate, bank;

        int row, col, height, top;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
            this.top = height;
            this.inundate = false;
            this.bank = false;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }
}