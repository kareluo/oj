package problems.p416;

class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) {
            return false;
        }

        sum >>= 1;
        boolean[] sums = new boolean[sum + 1];
        sums[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                if (!sums[i]) {
                    sums[i] = sums[i - num];
                }
            }
        }

        return sums[sum];
    }
}