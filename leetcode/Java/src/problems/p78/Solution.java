package problems.p78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new ArrayList<>();
        subsets(sets, new ArrayList<>(), nums, 0);
        return sets;
    }

    private void subsets(List<List<Integer>> sets, List<Integer> set, int[] nums, int index) {
        if (index >= nums.length) {
            sets.add(new ArrayList<>(set));
            return;
        }
        subsets(sets, set, nums, index + 1);
        set.add(nums[index]);
        subsets(sets, set, nums, index + 1);
        set.remove(set.size() - 1);
    }
}