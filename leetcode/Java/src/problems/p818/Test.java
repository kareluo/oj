package problems.p818;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 10000; i++) {
            System.out.println(i + ":" + solution.racecar(i));
        }
    }
}
