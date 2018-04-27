package problems.p401;

import util.PrinterUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 0; i < 15; i++) {
            PrinterUtils.println(solution.readBinaryWatch(i));
        }
    }
}
