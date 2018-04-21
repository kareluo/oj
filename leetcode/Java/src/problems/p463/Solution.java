package problems.p463;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int x, y, perimeter = 0;
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    x = j + dx[k];
                    y = i + dy[k];
                    if (x >= 0 && x < grid[i].length
                            && y >= 0 && y < grid.length) {
                        perimeter += grid[y][x] ^ 1;
                    } else perimeter++;
                }
            }
        }
        return perimeter;
    }
}


class Solution2 {
    public int islandPerimeter(int[][] grid) {
        int com = 0, island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                island++;
                if (i > 0 && grid[i - 1][j] == 1) com++;
                if (j > 0 && grid[i][j - 1] == 1) com++;
            }
        }
        return (island << 2) - (com << 1);
    }
}