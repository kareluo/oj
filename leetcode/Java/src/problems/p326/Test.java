package problems.p326;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i >= 0; i++) {
            if (solution.isPowerOfThree(i)) {
                System.out.println(i);
            }
        }
    }
}
