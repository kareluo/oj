package problems.p129;

import common.TreeNode;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        solution.sumNumbers(root);
    }
}
