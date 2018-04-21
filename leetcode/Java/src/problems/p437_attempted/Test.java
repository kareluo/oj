package problems.p437_attempted;

import common.TreeNode;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = build(new Integer[]{0, 10, 5, -3, 3, 2, null, 11, -3, -2, null, 1, null, null, 3}, 1);
        System.out.println(solution.pathSum(root, 8));
    }

    private static TreeNode build(Integer[] values, int i) {
        if (i >= values.length || values[i] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[i]);
        root.left = build(values, i << 1);
        root.right = build(values, (i << 1) | 1);
        return root;
    }
}
