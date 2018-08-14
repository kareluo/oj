package problems.p167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] < target - numbers[j]) {
                i++;
            } else if (numbers[i] > target - numbers[j]) {
                j--;
            } else break;
        }
        return new int[]{i + 1, j + 1};
    }
}