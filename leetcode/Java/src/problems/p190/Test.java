package problems.p190;

import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Random random = new Random();
        for (int i = 0; i < 100000000; i++) {
            int num = random.nextInt();
            int rnum = solution.reverseBits(num);
            for (int j = 0; j < 32; j++) {
                if(((num >> j) & 1) != ((rnum>>(31-j)) & 1)) {
                    throw new RuntimeException(String.format("Num=%d != RNum=%d", num, rnum));
                }
            }
        }
    }
}
