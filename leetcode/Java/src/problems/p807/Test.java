package problems.p807;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{}));
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{1}}));
        System.out.println(solution.maxIncreaseKeepingSkyline(new int[][]{{1, 1}, {1, 1}}));
    }
}
