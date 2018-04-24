package problems.p22;

import util.PrinterUtils;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 10; i++) {
            List<String> parenthesis = solution.generateParenthesis(i);
//            PrinterUtils.println(parenthesis);
            System.out.println(parenthesis.size());
        }
    }
}
