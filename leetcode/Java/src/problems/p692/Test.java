package problems.p692;

import util.PrinterUtils;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        PrinterUtils.println(solution.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
