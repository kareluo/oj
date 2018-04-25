package problems.p349;

import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int k = 0;
        int[] ins = new int[Math.min(nums1.length, nums2.length)];
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else {
                ins[k] = nums1[i];
                while (i < nums1.length && ins[k] == nums1[i]) i++;
                while (j < nums2.length && ins[k] == nums2[j]) j++;
                k++;
            }
        }
        int[] answer = new int[k];
        System.arraycopy(ins, 0, answer, 0, k);
        return answer;
    }
}