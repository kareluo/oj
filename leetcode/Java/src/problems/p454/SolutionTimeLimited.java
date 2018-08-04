package problems.p454;

import java.util.Arrays;

class SolutionTimeLimited {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;

        if (N == 0) return 0;

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        if (A[0] + B[0] + C[0] + D[0] > 0 || A[N - 1] + B[N - 1] + C[N - 1] + D[N - 1] < 0) {
            return 0;
        }

        int min2 = C[0] + D[0], min3 = B[0] + C[0] + D[0];
        int max2 = C[N - 1] + D[N - 1], max3 = B[N - 1] + C[N - 1] + D[N - 1];

        int count = 0;
        int startA = findStart(A, 0 - max3);
        int endA = findEnd(A, 0 - min3);
        for (int a = startA; a < endA; a++) {
            int startB = findStart(B, 0 - A[a] - max2);
            int endB = findEnd(B, 0 - A[a] - min2);
            for (int b = startB; b < endB; b++) {
                int startC = findStart(C, 0 - A[a] - B[b] - D[N - 1]);
                int endC = findEnd(C, 0 - A[a] - B[b] - D[0]);
                for (int c = startC; c < endC; c++) {
                    count += findCount(D, 0 - A[a] - B[b] - C[c]);
                }
            }
        }
        return count;
    }

    private int findStart(int[] nums, int x) {
        int i = Arrays.binarySearch(nums, x);
        if (i >= 0) {
            while (i >= 0 && nums[i] == x) i--;
            return i + 1;
        }
        return -(i + 1);
    }

    private int findEnd(int[] nums, int x) {
        int i = Arrays.binarySearch(nums, x);
        if (i >= 0) {
            while (i < nums.length && nums[i] == x) i++;
            return i;
        }
        return -(i + 1);
    }

    private int findCount(int[] nums, int x) {
        int i = Arrays.binarySearch(nums, x);
        int count = 0;
        if (i >= 0) {
            count++;
            for (int j = i + 1; j < nums.length && nums[j] == x; j++) {
                count++;
            }
            for (int j = i - 1; j >= 0 && nums[j] == x; j--) {
                count++;
            }
        }
        return count;
    }
}