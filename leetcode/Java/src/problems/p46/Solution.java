package problems.p46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int capacity = 1;
        for (int i = 2; i <= nums.length; i++) {
            capacity *= i;
        }
        List<List<Integer>> permutes = new ArrayList<>(capacity);
        permute(permutes, new int[nums.length], nums, 0, 0);
        return permutes;
    }

    private void permute(List<List<Integer>> permutes, int[] permute, int[] nums, int state, int index) {
        if (index >= nums.length) {
            List<Integer> ans = new ArrayList<>(nums.length);
            for (int pp : permute) {
                ans.add(pp);
            }
            permutes.add(ans);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (((state >> i) & 1) == 0) {
                permute[index] = nums[i];
                permute(permutes, permute, nums, state | (1 << i), index + 1);
            }
        }
    }
}