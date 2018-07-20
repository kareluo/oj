package problems.p39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> groups = new ArrayList<>();
        combine(groups, new Integer[target / candidates[0] + 1], candidates, -1, 0, target);

        return groups;
    }

    private void combine(List<List<Integer>> groups, Integer[] group, int[] candidates, int i, int index, int free) {

        if (free == 0) {
            Integer[] g = new Integer[i + 1];
            System.arraycopy(group, 0, g, 0, g.length);
            groups.add(Arrays.asList(g));
            return;
        }

        if (index >= candidates.length) return;

        int count = free / candidates[index];

        if (count == 0) return;

        for (int j = 1; j <= count; j++) {
            group[i + j] = candidates[index];
            combine(groups, group, candidates, i + j, index + 1, free - candidates[index] * j);
        }
        combine(groups, group, candidates, i, index + 1, free);
    }
}