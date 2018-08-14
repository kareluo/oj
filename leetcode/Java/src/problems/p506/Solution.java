package problems.p506;

import java.util.Arrays;

class Solution {

    public String[] findRelativeRanks(int[] nums) {
        int[][] indices = new int[nums.length][2];
        for (int i = 0; i < indices.length; i++) {
            indices[i][0] = nums[i];
            indices[i][1] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            if (a[0] == b[0]) {
                return 0;
            }
            return b[0] > a[0] ? 1 : -1;
        });
        String[] ranks = new String[nums.length];
        for (int i = 0; i < indices.length; i++) {
            ranks[indices[i][1]] = String.valueOf(i + 1);
        }
        if (indices.length > 0) {
            ranks[indices[0][1]] = "Gold Medal";
        }
        if (indices.length > 1) {
            ranks[indices[1][1]] = "Silver Medal";
        }
        if (indices.length > 2) {
            ranks[indices[2][1]] = "Bronze Medal";
        }
        return ranks;
    }
}