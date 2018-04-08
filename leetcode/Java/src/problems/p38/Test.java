package problems.p38;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int i = 1; i < 20; i++) {
            String s = solution.countAndSay(i);
            for (int j = s.length() - 1; j >= 0; j--) {
                System.out.print(s.charAt(j));
            }
            System.out.println();
        }
    }
}
