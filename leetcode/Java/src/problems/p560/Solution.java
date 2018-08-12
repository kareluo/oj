package problems.p560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += sums.getOrDefault(sum - k, 0);
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}