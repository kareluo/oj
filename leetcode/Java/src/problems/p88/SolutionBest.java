package problems.p88;

public class SolutionBest {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) nums1[k--] = nums2[j--];
    }
}
