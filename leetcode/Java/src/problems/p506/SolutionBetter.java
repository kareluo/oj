package problems.p506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionBetter {

    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] ranks = new String[nums.length];

        int rank = nums.length;
        for (int num : nums) {
            ranks[indices.get(num)] = String.valueOf(rank--);
        }
        if (ranks.length > 0) {
            ranks[indices.get(nums[nums.length - 1])] = "Gold Medal";
        }
        if (ranks.length > 1) {
            ranks[indices.get(nums[nums.length - 2])] = "Silver Medal";
        }
        if (ranks.length > 2) {
            ranks[indices.get(nums[nums.length - 3])] = "Bronze Medal";
        }
        return ranks;
    }
}
