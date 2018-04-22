package problems.p75;

class Solution {

    public void _sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) counts[num]++;
        for (int i = 0, j = 0, k; i < 3; i++) {
            k = counts[i];
            while (k-- > 0) nums[j++] = i;
        }
    }

    public void sortColors(int[] nums) {
        int p0 = 0, i = 0, p2 = nums.length - 1;
        while (i <= p2) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
            }
            if (nums[i] == 2) {
                nums[i] = nums[p2];
                nums[p2--] = 2;
                i--;
            }
            i++;
        }
    }
}