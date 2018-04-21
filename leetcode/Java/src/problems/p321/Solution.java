package problems.p321;

class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        if (k <= 0) return new int[0];

        int[][] f1 = new int[nums1.length][nums1.length];
        int[][] f2 = new int[nums2.length][nums2.length];

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 0; j < i; j++) {
                f1[j][i] = nums1[i] > nums1[f1[j][i - 1]] ? i : f1[j][i - 1];
            }
            f1[i][i] = i;
        }

        for (int i = 1; i < nums2.length; i++) {
            for (int j = 0; j < i; j++) {
                f2[j][i] = nums2[i] > nums2[f2[j][i - 1]] ? i : f2[j][i - 1];
            }
            f2[i][i] = i;
        }

        int[] nums = new int[k];
        number(nums1, nums2, f1, f2, 0, 0, k, 0, nums);

        return nums;
    }

    private void number(int[] num1, int[] num2, int[][] f1, int[][] f2, int begin1, int begin2, int k, int i, int[] nums) {

        int length1 = num1.length - begin1;
        int length2 = num2.length - begin2;

        int end1 = num1.length - 1;
        if (length2 < k) {
            end1 -= k - length2 - 1;
        }

        int end2 = num2.length - 1;
        if (length1 < k) {
            end2 -= k - length1 - 1;
        }

        if (length2 <= 0) {
            int index1 = f1[begin1][end1];
            if (nums[i] <= num1[index1]) {
                nums[i] = num1[index1];
                if (k > 1) {
                    number(num1, num2, f1, f2, index1 + 1, begin2, k - 1, i + 1, nums);
                }
            }
            return;
        } else if (length1 <= 0) {
            int index2 = f2[begin2][end2];
            if (nums[i] <= num2[index2]) {
                nums[i] = num2[index2];
                if (k > 1) {
                    number(num1, num2, f1, f2, begin1, index2 + 1, k - 1, i + 1, nums);
                }
            }
            return;
        }

        int index1 = f1[begin1][end1];
        int index2 = f2[begin2][end2];

        if (num1[index1] > num2[index2]) {
            if (nums[i] <= num1[index1]) {
                nums[i] = num1[index1];
                if (k > 1) {
                    number(num1, num2, f1, f2, index1 + 1, begin2, k - 1, i + 1, nums);
                }
            }
        } else if (num1[index1] < num2[index2]) {
            if (nums[i] <= num2[index2]) {
                nums[i] = num2[index2];
                if (k > 1) {
                    number(num1, num2, f1, f2, begin1, index2 + 1, k - 1, i + 1, nums);
                }
            }
        } else {
            if (nums[i] <= num1[index1]) {
                nums[i] = num1[index1];
                if (k > 1) {
                    number(num1, num2, f1, f2, index1 + 1, begin2, k - 1, i + 1, nums);
                    number(num1, num2, f1, f2, begin1, index2 + 1, k - 1, i + 1, nums);
                }
            }
        }
    }
}