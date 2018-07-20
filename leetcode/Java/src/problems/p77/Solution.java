package problems.p77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> groups = new LinkedList<>();
        combine(groups, new Integer[k], 1, 0, n, k);
        return groups;
    }

    private void combine(List<List<Integer>> groups, Integer[] group, int i, int size, int n, int k) {
        if (size >= k) {
            groups.add(new ArrayList<>(Arrays.asList(group)));
            return;
        }
        if (i > n) return;
        group[size] = i;
        combine(groups, group, i + 1, size + 1, n, k);
        combine(groups, group, i + 1, size, n, k);
    }
}