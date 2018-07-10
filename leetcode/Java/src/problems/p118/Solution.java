package problems.p118;

import util.PrinterUtils;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> nums = new LinkedList<>();
            long num = 1;
            nums.add((int) num);
            for (int j = 1; j <= i; j++) {
                num = num * (i - j + 1) / j;
                nums.add((int) num);
            }
            triangle.add(nums);
        }
        PrinterUtils.println(triangle);
        return triangle;
    }
}