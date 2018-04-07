package problems.p4;

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int middle = (length - 1) >> 1;
        int i = 0, j = 0, index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (index >= middle) break;
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            index++;
        }

        if (index != middle) {
            if (i < nums1.length) {
                i += middle - index;
            }

            if (j < nums2.length) {
                j += middle - index;
            }
        }

        double ans = 0;
        if (i < nums1.length && j < nums2.length) {
            ans = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        } else if (i < nums1.length) {
            ans = nums1[i++];
        } else if (j < nums2.length) {
            ans = nums2[j++];
        }

        if ((length & 1) == 0) {
            if (i < nums1.length && j < nums2.length) {
                ans = (ans + (nums1[i] < nums2[j] ? nums1[i++] : nums2[j++])) / 2.0;
            } else if (i < nums1.length) {
                ans = (ans + nums1[i++]) / 2.0;
            } else if (j < nums2.length) {
                ans = (ans + nums2[j++]) / 2.0;
            }
        }

        return ans;
    }
}