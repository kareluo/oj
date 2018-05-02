package problems.p453;

class Solution {

    // TODO incorrect
    public int minMoves(int[] nums) {
        int sh = 0, h = Integer.MIN_VALUE;
        for (int num : nums) {
            sh += num;
            if (num > h) {
                h = num;
            }
        }
        for (int n = nums.length, less = n - 1; ; h++) {
            if ((n * h - sh) % less == 0) {
                System.out.println(h);
                return (n * h - sh) / less;
            }
        }
    }
}