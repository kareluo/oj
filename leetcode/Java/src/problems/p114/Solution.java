package problems.p114;

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

    public void flatten(TreeNode root) {
        if (root != null) {
            tail(root);
        }
    }

    private TreeNode tail(TreeNode root) {
        TreeNode left = root.left, right = root.right;
        if (left != null) {
            left = tail(left);
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (right != null) {
            return tail(right);
        }

        if (left != null) {
            return left;
        }

        return root;
    }
}