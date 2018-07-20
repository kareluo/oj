package problems.p367;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 10000; i++) {
            if (solution.isPerfectSquare(i)) {
                System.out.println(i);
            }
        }
    }
}
