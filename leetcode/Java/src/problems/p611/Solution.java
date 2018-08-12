package problems.p611;

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        int[] sides = new int[1001];
        Arrays.sort(nums);
        for (int num : nums) sides[num]++;
        for (int i = 1; i <= 1000; i++) {
            sides[i] += sides[i - 1];
        }
        int triangles = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int side = nums[i] + nums[j] - 1;
                if (side <= 1000 && side >= 0 && sides[side] - j - 1 > 0) {
                    triangles += sides[side] - j - 1;
                }
            }
        }
        return triangles;
    }
}