package problems.p404;

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, false);
    }

    private int sum(TreeNode root, boolean left) {
        if (root == null) return 0;
        if (left && root.left == null && root.right == null) {
            return root.val;
        }
        return sum(root.left, true) + sum(root.right, false);
    }
}