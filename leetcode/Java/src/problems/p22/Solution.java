package problems.p22;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesises = new ArrayList<>(n);
        StringBuilder sb = new StringBuilder();
        sb.setLength(n << 1);
        generate(parenthesises, sb, n, n, 0);
        return parenthesises;
    }

    private void generate(List<String> ps, StringBuilder sb, int a, int b, int index) {
        if (a == 0 && b == 0) {
            ps.add(sb.toString());
            return;
        }
        if (a > 0) {
            sb.setCharAt(index, '(');
            generate(ps, sb, a - 1, b, index + 1);
        }
        if (b > a) {
            sb.setCharAt(index, ')');
            generate(ps, sb, a, b - 1, index + 1);
        }
    }
}