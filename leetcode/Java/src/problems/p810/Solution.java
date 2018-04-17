package problems.p810;

class Solution {
    public boolean xorGame(int[] nums) {
        int xors = 0;
        for (int num : nums) xors ^= num;
        return (nums.length & 1) == 0 || xors == 0;
    }
}