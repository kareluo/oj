package problems.p407;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class SolutionHeap {

    private int rows, cols;

    private Heap<Cell> cells = new Heap<Cell>() {
        @Override
        public boolean compare(Cell a, Cell b) {
            return a.height < b.height;
        }
    };

    private Cell[][] cellMap = new Cell[111][111];

    private static final int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        rows = heightMap.length;
        cols = heightMap[0].length;

        cells.clear();
        for (int i = 0; i < rows; i++) {
            boolean bank = i == 0 || i == rows - 1;
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j, heightMap[i][j]);
                cell.bank = bank || j == 0 || j == cols - 1;
                if (cell.bank) cells.push(cell);
                cellMap[i][j] = cell;
            }
        }

        while (!cells.isEmpty()) {
            Cell cell = cells.pop();
            if (!cell.inundate && cell.bank) {
                fill(cell, cell.height);
            }
        }

        int volume = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                volume += cellMap[i][j].volume();
            }
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
                    cells.push(nextCell);
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

        int volume() {
            return top - height;
        }

        @Override
        public int compareTo(Cell o) {
            return this.height - o.height;
        }
    }

    private static abstract class Heap<T> {

        List<T> values;

        public Heap() {
            this.values = new ArrayList<>();
        }

        public Heap(int initialCapacity) {
            this.values = new ArrayList<>(initialCapacity);
        }

        public void push(T value) {
            this.values.add(value);
            adjustFromBottom();
        }

        public int size() {
            return this.values.size();
        }

        public void clear() {
            values.clear();
        }

        public boolean isEmpty() {
            return this.values.isEmpty();
        }

        private void adjustFromBottom() {
            if (isEmpty()) return;
            int index = size() - 1;
            while (compare(values.get(index), values.get(index >> 1))) {
                swap(index, index >> 1);
                index >>= 1;
            }
        }

        private void adjustFromTop() {
            if (isEmpty()) return;
            int index = 0, size = size();
            while (index < size) {
                int next = index, i = index << 1;
                if (i < size && compare(values.get(i), values.get(next))) {
                    next = i;
                }
                i++;
                if (i < size && compare(values.get(i), values.get(next))) {
                    next = i;
                }
                if (index != next) {
                    swap(index, next);
                    index = next;
                } else break;
            }
        }

        private void swap(int i, int j) {
            T temp = values.get(i);
            values.set(i, values.get(j));
            values.set(j, temp);
        }

        public T pop() {
            T top = values.get(0);
            if (size() > 1) {
                values.set(0, values.remove(size() - 1));
            } else values.remove(0);
            adjustFromTop();
            return top;
        }

        public abstract boolean compare(T a, T b);
    }
}