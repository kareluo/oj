package problems.p166;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fractionToDecimal(-50, 8));
        System.out.println(solution.fractionToDecimal(-1, -2147483648));
        System.out.println(solution.fractionToDecimal(1, 90));
        System.out.println(solution.fractionToDecimal(1, 2));
        System.out.println(solution.fractionToDecimal(2, 1));
        System.out.println(solution.fractionToDecimal(2, 3));
        System.out.println(solution.fractionToDecimal(2, 15));
        System.out.println(solution.fractionToDecimal(12, 90));
        System.out.println(solution.fractionToDecimal(1, 3));
        System.out.println(solution.fractionToDecimal(1, 7));
        System.out.println(solution.fractionToDecimal(11231231, 7));
        System.out.println(solution.fractionToDecimal(0, 7));
        System.out.println(solution.fractionToDecimal(7, 7));
        System.out.println(solution.fractionToDecimal(1, 9));
        System.out.println(solution.fractionToDecimal(1233, 9990));
        System.out.println(solution.fractionToDecimal(558843, 999900));
        System.out.println(solution.fractionToDecimal(1234, 9999));
    }
}
