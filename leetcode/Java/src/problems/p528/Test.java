package problems.p528;

import util.PrinterUtils;

public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{100};
        Solution solution = new Solution(nums);

        int[] counts = new int[nums.length];
        for (int i = 0; i < 2333; i++) {
            counts[solution.pickIndex()]++;
        }
        PrinterUtils.println(counts);
    }
}
