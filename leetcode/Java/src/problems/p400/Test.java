package problems.p400;

import util.TimeUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 1; i < 101; i++) {
            System.out.println(i);
        }

        TimeUtils.begin();
        for (int i = 1; i < 10000000; i++) {
            solution.findNthDigit(i);
        }
        TimeUtils.end();
    }
}
