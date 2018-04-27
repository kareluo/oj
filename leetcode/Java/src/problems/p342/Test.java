package problems.p342;

public class Test {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        for (int i = 0; i < 2147483647; i++) {
            if (solution.isPowerOfFour(i)) {
                System.out.println(i);
            }
        }
    }
}
