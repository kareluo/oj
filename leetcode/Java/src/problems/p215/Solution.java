package problems.p215;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        sort(nums, 0, nums.length - 1, k);
        return nums[k];
    }

    private void sort(int[] numbers, int begin, int end, int k) {
        if (begin >= end) return;
        int i = begin, j = end, mid = numbers[(begin + end) >> 1];
        do {
            while (numbers[i] < mid) i++;
            while (numbers[j] > mid) j--;
            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (i <= end && i <= k) sort(numbers, i, end, k);
        else if (begin <= j && j >= k) sort(numbers, begin, j, k);
    }
}