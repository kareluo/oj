package problems.p338;

import util.PrinterUtils;
import util.TimeUtils;
import util.Utils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        TimeUtils.begin();
        for (int i = 0; i < 100000; i++) {
            if (!Utils.equals(solution.countBits(i), solution2.countBits(i))) {
                System.out.println(i);
                break;
            }
        }
        TimeUtils.end();

        PrinterUtils.println(solution.countBits(11));


    }
}
