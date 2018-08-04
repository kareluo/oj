package problems.p459;

import util.RandomUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            String s = RandomUtils.random(random, 0, 6);
//            String s = "czcz";
            boolean b = solution.repeatedSubstringPattern(s);
            boolean a = false;
            for (int j = 1; j <= s.length() / 2; j++) {
                if (s.length() % j == 0) {
                    int count = s.length() / j;
                    int index = 0;
                    String sub = s.substring(0, j);
                    do {
                        index = s.indexOf(sub, index);
                        if (index < 0) break;
                        count--;
                        index += sub.length();
                    } while (index < s.length());
                    a |= count == 0;
                    if (a) break;
                }
            }
            if (a ^ b) {
                System.out.println(s);
            }
        }
    }
}
