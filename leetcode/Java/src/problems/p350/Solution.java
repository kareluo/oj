package problems.p350;

import java.util.Arrays;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                intersection[k++] = nums1[i];
                i++;
                j++;
            }
        }
        int[] answer = new int[k];
        System.arraycopy(intersection, 0, answer, 0, k);
        return answer;
    }
}