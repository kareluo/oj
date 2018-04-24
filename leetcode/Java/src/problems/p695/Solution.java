package problems.p695;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int area = 0, maximum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    area = area(grid, j, i);
                    if (area > maximum) {
                        maximum = area;
                    }
                }
            }
        }
        return maximum;
    }

    private int area(int[][] map, int x, int y) {
        if (y < 0 || y >= map.length || x < 0 || x >= map[y].length) {
            return 0;
        }

        if (map[y][x] == 0) {
            return 0;
        }

        int area = 1;
        map[y][x] = 0;
        area += area(map, x, y - 1);
        area += area(map, x - 1, y);
        area += area(map, x + 1, y);
        area += area(map, x, y + 1);

        return area;
    }
}