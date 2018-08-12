package problems.p108;

import common.TreeNode;

public class Test {

    private static int[][] arrays = new int[][]{
            {-10, -3, 0, 5, 9},
            {},
            {12},
            {1, 2, 3, 3},
            {1},
            {1, 2},
            {1, 2, 3},
            {1, 2, 3, 4},
            {1, 2, 3, 4, 5},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 3, 4, 5, 6, 7, 8},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 122, 1232, 12323}
    };


    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < arrays.length; i++) {
            if (!test(solution.sortedArrayToBST(arrays[i]))) {
                System.out.println("Test abort.");
            }
        }
    }

    private static boolean test(TreeNode root) {
        if (root == null) return true;

        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }

        return test(root.left) && test(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
