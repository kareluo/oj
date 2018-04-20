package problems.p110;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean isBalanced(TreeNode root) {
        return root == null || height(root) > 0;
    }

    private int height(TreeNode root) {
        int lHeight = 0;
        if (root.left != null) {
            lHeight = height(root.left);
        }
        if (lHeight < 0) return -1;

        int rHeight = 0;
        if (root.right != null) {
            rHeight = height(root.right);
        }
        if (rHeight < 0) return -1;

        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }

        return Math.max(lHeight, rHeight) + 1;
    }
}