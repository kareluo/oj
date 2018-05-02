package problems.p599;

import util.PrinterUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        PrinterUtils.println(solution.findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KNN", "KFC", "Burger King", "Tapioca Express", "Shogun"}
        ));
    }
}
