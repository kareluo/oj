package problems.p792;

import util.RandomUtils;
import util.TimeUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        SolutionEasy solutionEasy = new SolutionEasy();

        Random random = new Random();
        long millis, d1 = 0, d2 = 0;
        for (int i = 0; i < 1000; i++) {
            String S = RandomUtils.random(random, 1000, 50000);
            int len = random.nextInt(5000) + 1;
            String[] words = new String[len + 1];
            for (int j = len; j >= 0; j--) {
                words[j] = RandomUtils.random(random, 10, 60);
            }

            millis = System.currentTimeMillis();
            solution.numMatchingSubseq(S, words);
            d1 += System.currentTimeMillis() - millis;

            millis = System.currentTimeMillis();
            solutionEasy.numMatchingSubseq(S, words);
            d2 += System.currentTimeMillis() - millis;

            if (solution.numMatchingSubseq(S, words) != solutionEasy.numMatchingSubseq(S, words)) {
                System.out.println(S);
            }
        }

        System.out.println(String.format("duration 1: %d, duration 2(easy): %d", d1, d2));
    }
}
