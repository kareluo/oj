package problems.p889;

class Solution {

    private static final int[][] dcr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] coordinates = new int[R * C][2];
        int direction = 3, steps = 0;
        int cells = 0, step = 0, turns = 1;
        while (cells < coordinates.length) {
            if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                coordinates[cells][0] = r0;
                coordinates[cells][1] = c0;
                cells++;
            }
            if (step == steps) {
                turns = (turns + 1) % 2;
                if (turns == 0) {
                    steps++;
                }
                step = 0;
                direction = (direction + 1) % 4;
            }
            step++;
            r0 += dcr[direction][0];
            c0 += dcr[direction][1];
        }
        return coordinates;
    }
}