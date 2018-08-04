package problems.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>();

        Arrays.sort(nums);

        int[] next = new int[nums.length];
        int num = nums[nums.length - 1];
        for (int i = nums.length - 1, j = nums.length; i >= 0; i--) {
            if (nums[i] != num) {
                j = i + 1;
                num = nums[i];
            }
            next[i] = j;
        }

        List<List<Integer>> results = new ArrayList<>();

        int n = nums.length;
        int last = nums[n - 1];
        int last2 = last + nums[n - 2];
        int last3 = last2 + nums[n - 3];

        for (int i = 0; i < n - 3; i = next[i]) {
            int sumi = nums[i];

            if (sumi + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (sumi + last3 < target) continue;

            for (int j = i + 1; j < n - 2; j = next[j]) {
                int sumj = sumi + nums[j];

                if (sumj + nums[j + 1] + nums[j + 2] > target) break;
                if (sumj + last2 < target) continue;

                for (int k = j + 1; k < n - 1; k = next[k]) {
                    int sumk = sumj + nums[k];
                    if (sumk + nums[k + 1] > target) break;
                    if (sumk + last < target) continue;

                    for (int z = k + 1; z < n; z = next[z]) {
                        int sumz = sumk + nums[z];
                        if (sumz > target) break;
                        if (sumz == target) {
                            results.add(Arrays.asList(nums[i], nums[j], nums[k], nums[z]));
                            break;
                        }
                    }
                }
            }
        }

        return results;
    }
}
