package problems.p119;

import util.TimeUtils;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TimeUtils.begin();
        for (int i = 0; i < 100000; i++) {
            solution.getRow(29);
        }
        TimeUtils.end();

        for (int i = 0; i < 50; i++) {
            List<Integer> row = solution.getRow(i);
            for (Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
