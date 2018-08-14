package problems.p886;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3));
        System.out.println(solution.reachableNodes(new int[][]{{0,1,4},{1,2,6},{0,2,8},{1,3,1}}, 1, 4));
    }
}
