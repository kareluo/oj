package problems.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0, maxi = nums.length - 2, j, k, numi, numj, numk; i < maxi; ) {
            numi = nums[i];
            if (numi > 0) break;

            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                numj = nums[j];
                numk = -numi - numj;
                if (numk < nums[k]) k--;
                else if (numk > nums[k]) j++;
                else {
                    answer.add(Arrays.asList(nums[i], nums[j], numk));
                    j++;
                    while (j < k && nums[j] == numj) j++;

                    k--;
                    while (j < k && nums[k] == numk) k--;
                }
            }

            i++;
            while (i < maxi && nums[i] == numi) i++;
        }

        return answer;
    }
}