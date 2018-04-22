package problems.p448;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int count = 0;
        boolean nAppear = false;
        for (int i = 0, num; i < nums.length; i++) {
            num = Math.abs(nums[i]);
            if (num == nums.length) {
                if (!nAppear) {
                    count++;
                }
                nAppear = true;
            } else if (nums[num] > 0) {
                count++;
                nums[num] = -nums[num];
            }
        }

        List<Integer> res = new ArrayList<>(nums.length - count);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i);
        }
        if (!nAppear && nums.length > 0) res.add(nums.length);
        return res;
    }
}