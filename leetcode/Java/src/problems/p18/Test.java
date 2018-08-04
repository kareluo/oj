package problems.p18;

import util.PrinterUtils;
import util.RandomUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        SolutionBad2 solution = new SolutionBad2();
        solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        Random random = new Random();

        PrinterUtils.println(RandomUtils.random(random, 0, 0, 100));
        PrinterUtils.println(RandomUtils.random(random, 0, 0, 100));
        PrinterUtils.println(RandomUtils.random(random, 0, 0, 100));


        int[] nums = RandomUtils.random(random, 0, 0, 1000);
        solution.fourSum(nums, 20);
    }
}
