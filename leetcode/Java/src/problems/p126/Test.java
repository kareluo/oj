package problems.p126;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class Test {

    private static final int TIMES = 1;

    public static void main(String[] args) {
        long start_millis;

        Solution1 solution = new Solution1();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        start_millis = System.currentTimeMillis();
        List<List<String>> results = solution.findLadders(beginWord, endWord, wordList);
        System.out.println("Millis:" + (System.currentTimeMillis() - start_millis));
        for (List<String> result : results) {
            System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
        }

        Solution2 solution2 = new Solution2();
        start_millis = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            results = solution2.findLadders(beginWord, endWord, wordList);
        }
        System.out.println("Millis:" + (System.currentTimeMillis() - start_millis));
        for (List<String> result : results) {
            System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
        }

        Solution sol = new Solution();

        start_millis = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            results = sol.findLadders(beginWord, endWord, wordList);
        }
        System.out.println("Millis:" + (System.currentTimeMillis() - start_millis));

        for (List<String> result : results) {
            System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
        }

    }
}
