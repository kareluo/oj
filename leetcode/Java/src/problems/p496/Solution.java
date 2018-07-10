package problems.p496;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] pos = new int[10001];

        if (nums2.length > 0) {
            pos[nums2[nums2.length - 1]] = -1;
        }
        for (int i = nums2.length - 2, j; i >= 0; i--) {
            j = i + 1;
            while (nums2[j] < nums2[i]) {
                j = pos[nums2[j]];
                if (j < 0) {
                    break;
                }
            }
            pos[nums2[i]] = j;
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            if (pos[nums1[i]] >= 0) {
                ans[i] = nums2[pos[nums1[i]]];
            }
        }
        return ans;
    }
}