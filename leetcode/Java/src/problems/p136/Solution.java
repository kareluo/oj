package problems.p136;

class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n : nums) num ^= n;
        return num;
    }
}