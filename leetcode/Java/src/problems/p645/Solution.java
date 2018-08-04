package problems.p645;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int[] counts = new int[nums.length + 1];
        for (int num : nums) counts[num]++;
        for (int i = 1; i <= nums.length; i++) {
            if (counts[i] == 2) {
                result[0] = i;
            } else if (counts[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }
}