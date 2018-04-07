package problems.p461;

import util.TimeUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        TimeUtils.begin();
        for (int i = 0; i < 10000000; i++) {
            solution.hammingDistance(21437732, 4);
        }
        TimeUtils.end();
    }
}
