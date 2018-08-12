package problems.p98;

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

    private long previous = Integer.MIN_VALUE - 1L;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= previous) {
            return false;
        }
        previous = root.val;
        return isValidBST(root.right);
    }
}