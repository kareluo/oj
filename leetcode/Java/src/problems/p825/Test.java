package problems.p825;

import util.PrinterUtils;
import util.RandomUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionBest best = new SolutionBest();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int[] ages = RandomUtils.random(random, 1, 120, 20000);
            if (solution.numFriendRequests(ages) != best.numFriendRequests(ages)) {
                PrinterUtils.println(ages);
            }
        }
    }
}
