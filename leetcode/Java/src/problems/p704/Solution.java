package problems.p704;

class Solution {
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int begin = 0, end = nums.length;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            } else return mid;
        }
        return -1;
    }
}