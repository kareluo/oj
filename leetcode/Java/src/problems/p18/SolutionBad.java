package problems.p18;

import java.util.*;

class SolutionBad {

    private Map<Integer, Integer> next = new HashMap<>();

    private List<List<Integer>> results = new ArrayList<>();

    private Integer[] candidates = new Integer[4];

    public List<List<Integer>> fourSum(int[] nums, int target) {
        results.clear();
        if (nums.length < 4) return results;

        Arrays.sort(nums);

        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num != nums[i]) {
                next.put(num, i);
                num = nums[i];
            }
        }
        next.put(num, nums.length + 1);
        find(nums, 0, 0, target);

        return results;
    }

    private void find(int[] nums, int index, int pos, int target) {
        if (target == 0 && pos > 3) {
            results.add(new ArrayList<>(Arrays.asList(candidates)));
            return;
        }
        if (index >= nums.length || pos > 3) return;
        int num = nums[index];
        if (pos == 3 && num > target) return;
        candidates[pos] = num;
        find(nums, index + 1, pos + 1, target - num);
        find(nums, next.get(num), pos, target);
    }
}