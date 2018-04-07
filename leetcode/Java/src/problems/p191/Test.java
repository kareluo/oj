package problems.p191;

import util.TimeUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TimeUtils.begin();
        for (int i = 0; i < 1000000; i++) {
            solution.hammingWeight(11);
            solution.hammingWeight(-1);
        }
        TimeUtils.end();
    }
}
