package problems.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionBad2 {

    private int[] next;

    private Integer[] candidates = new Integer[4];

    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        results.clear();

        Arrays.sort(nums);

        int last = nums.length - 1;
        next = new int[nums.length];
        int num = nums[last];
        for (int i = last, j = nums.length; i >= 0; i--) {
            if (nums[i] != num) {
                j = i + 1;
                num = nums[i];
            }
            next[i] = j;
        }

        find(nums, 0, 0, target);

        return results;
    }

    private void find(int[] nums, int index, int pos, int target) {
        if (pos > 3 || index >= nums.length) {
            if (target == 0 && pos == 4) {
                results.add(new ArrayList<>(Arrays.asList(candidates)));
            }
            return;
        }
        if (pos == 3 && nums[index] > target) return;
        if (pos == 3) {
            if (nums[index] > target) return;
            while (index < nums.length && nums[index] < target) index = next[index];
            if (index >= nums.length) return;
            candidates[pos] = nums[index];
            find(nums, index, pos + 1, target - candidates[pos]);
        } else {
            candidates[pos] = nums[index];
            find(nums, index + 1, pos + 1, target - candidates[pos]);
            find(nums, next[index], pos, target);
        }
    }
}
