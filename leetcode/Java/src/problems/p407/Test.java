package problems.p407;

import util.PrinterUtils;
import util.RandomUtils;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        SolutionHeap solution = new SolutionHeap();
        System.out.println(solution.trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
        System.out.println(solution.trapRainWater(new int[][]{{9, 9, 9, 9, 9}, {9, 2, 1, 2, 9}, {9, 2, 8, 2, 9}, {9, 2, 3, 2, 9}, {9, 9, 9, 9, 9}}));

        Random random = new Random();

        Solution s = new Solution();
        SolutionMedium ss = new SolutionMedium();
        int success = 0;
        long duration1 = 0, duration2 = 0, millis;
        for (int i = 0; i < 1000; i++) {
            int[][] map = RandomUtils.random(1, 110, 1, 110, 1, 20000);

            millis = System.currentTimeMillis();
            int ans1 = s.trapRainWater(map);
            duration1 += System.currentTimeMillis() - millis;
            millis = System.currentTimeMillis();
            int ans2 = ss.trapRainWater(map);
            duration2 += System.currentTimeMillis() - millis;

            if (ans1 != ans2) {
                System.out.println(String.format("%d != %d", ans1, ans2));
                PrinterUtils.println(map);
            } else success++;
        }
        System.out.println(String.format("Success=%d, duration1=%d, duratiion2=%d", success, duration1, duration2));
    }
}
