package problems.p54;

import util.PrinterUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        PrinterUtils.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        PrinterUtils.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
