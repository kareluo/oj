package problems.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int[] next = new int[nums.length];
        int index = nums.length, num = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == num) {
                next[i] = index;
            } else {
                index = i + 1;
                num = nums[i];
                next[i] = index;
            }
        }

        List<List<Integer>> sets = new ArrayList<>();
        subsets(sets, new ArrayList<>(), nums, 0, next);
        return sets;
    }

    private void subsets(List<List<Integer>> sets, List<Integer> set, int[] nums, int index, int[] next) {
        if (index >= nums.length) {
            sets.add(new ArrayList<>(set));
            return;
        }
        subsets(sets, set, nums, next[index], next);
        set.add(nums[index]);
        subsets(sets, set, nums, index + 1, next);
        set.remove(set.size() - 1);
    }
}