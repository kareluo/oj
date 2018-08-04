package problems.p623;

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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return travel(root, v, d, true);
    }

    private TreeNode travel(TreeNode root, int v, int d, boolean left) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            if (left) {
                node.left = root;
            } else {
                node.right = root;
            }
            return node;
        }
        if (root == null) return null;
        root.left = travel(root.left, v, d - 1, true);
        root.right = travel(root.right, v, d - 1, false);
        return root;
    }
}