package problems.p200;

import util.PrinterUtils;
import util.RandomUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Random random = new Random();
        char[][] chars = RandomUtils.randomChars(random, 100, 100);

        PrinterUtils.println(chars);
    }
}
