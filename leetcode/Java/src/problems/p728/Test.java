package problems.p728;

import util.AssertUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 1; i < 10000; i++) {
            for (int j = i + 1; j < 10000; j++) {
                if (!AssertUtils.equalsCollection(solution.selfDividingNumbers(i, j),
                        solution.selfDividingNumbers2(i, j))) {
                    System.out.println("Begin=" + i + ", End=" + j);
                }
            }
        }
    }
}
