package problems.p119;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> results = new ArrayList<>(rowIndex + 1);
        results.add(1);
        int half = rowIndex >> 1;
        if (rowIndex >= 30) {
            long p = 1;
            for (int i = 1; i <= half; i++) {
                p = (rowIndex - i + 1) * p / i;
                results.add((int) p);
            }
        } else {
            for (int i = 1, p = 1; i <= half; i++) {
                p = (rowIndex - i + 1) * p / i;
                results.add(p);
            }
        }

        for (int i = rowIndex - half - 1; i >= 0; i--) {
            results.add(results.get(i));
        }
        return results;
    }
}