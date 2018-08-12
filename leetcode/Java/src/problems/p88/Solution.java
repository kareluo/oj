package problems.p88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        if (i < m) {
            System.arraycopy(nums1, i, nums, k, m - i);
        } else {
            System.arraycopy(nums2, j, nums, k, n - j);
        }
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }
}