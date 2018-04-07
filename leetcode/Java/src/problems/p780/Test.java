package problems.p780;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reachingPoints(2, 4, 15, 9));

        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            int sx = random.nextInt(40) + 1;
            int sy = random.nextInt(40) + 1;

            int tx = sx, ty = sy;
            int count = random.nextInt(10);
            for (int j = 0; j < count; j++) {
                if (random.nextBoolean()) {
                    tx = tx + ty;
                } else {
                    ty = tx + ty;
                }
                if (tx > 1 << 29 || ty > 1 << 29) break;
            }

            if (!solution.reachingPoints(sx, sy, tx, ty)) {
                System.out.println(String.format("%d, %d, %d, %d", sx, sy, tx, ty));
                break;
            }
        }
    }
}
