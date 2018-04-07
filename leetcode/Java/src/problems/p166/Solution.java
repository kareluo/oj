package problems.p166;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String fractionToDecimal(int n, int d) {
        StringBuilder sb = new StringBuilder();
        long numerator = n, denominator = d;
        if (numerator < 0 && denominator > 0
                || numerator > 0 && denominator < 0) {
            sb.append("-");
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        sb.append(numerator / denominator);
        numerator %= denominator;

        if (numerator != 0) {
            sb.append(".");
            int index = -sb.length(), i = 0;
            Map<Long, Integer> remainders = new HashMap<>();
            remainders.put(numerator, 0);
            while (numerator != 0) {
                numerator *= 10;
                sb.append(Math.abs(numerator / denominator));
                numerator %= denominator;
                Integer nb = remainders.get(numerator);
                if (nb != null) {
                    index = nb - index;
                    break;
                }
                remainders.put(numerator, ++i);
            }
            if (index >= 0) {
                sb.insert(index, "(").append(")");
            }
        }
        return sb.toString();
    }
}