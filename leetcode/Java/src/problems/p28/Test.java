package problems.p28;

import util.RandomUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String T = RandomUtils.random(random, 0, 5);
            String P = RandomUtils.random(random, 0, 10);
            if (solution.strStr(T, P) != T.indexOf(P)) {
                System.err.println(T);
                System.err.println(P);
                System.err.println();
                break;
            } else {
                System.out.println(solution.strStr(T, P));
            }
        }
    }
}
