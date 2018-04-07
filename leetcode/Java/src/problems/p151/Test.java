package problems.p151;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseWords(" "));
        System.out.println(solution.reverseWords(" the"));
        System.out.println(solution.reverseWords("the sky is blue"));


        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            int len = random.nextInt(10) + 1;
            for (int j = 0; j < len; j++) {
                char[] chs = new char[random.nextInt(10) + 1];
                for (int k = 0; k < chs.length; k++) {
                    chs[k] = (char) (random.nextInt(26) + 'a');
                }
                sb.append(" ").append(chs);
            }
            sb.deleteCharAt(0);
            System.out.println(sb.toString());
            System.out.println(solution.reverseWords(sb.toString()));
            System.out.println();
        }

    }
}
