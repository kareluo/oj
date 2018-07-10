package problems.p35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        return index;
    }
}

class Solution2 {
    public int searchInsert(int[] nums, int target) {
        int mid, begin = 0, end = nums.length;
        while (begin < end) {
            mid = (begin + end) >> 1;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }
}