package problems.p554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> widths = new HashMap<>();
        for (List<Integer> row : wall) {
            int width = 0;
            for (Integer brick : row) {
                width += brick;
                widths.put(width, widths.getOrDefault(width, 0) + 1);
            }
            widths.remove(width);
        }

        int rows = 0;
        for (int row : widths.values()) {
            if (row > rows) {
                rows = row;
            }
        }

        return wall.size() - rows;
    }
}