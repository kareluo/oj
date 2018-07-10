package problems.p653;

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
    public boolean findTarget(TreeNode root, int k) {
        return root != null && (find(root, k - root.val)
                || findTarget(root.left, k) || findTarget(root.right, k));
    }

    public boolean find(TreeNode root, int k) {
        if (root == null) return false;
        if (root.val < k) return find(root.right, k);
        if (root.val > k) return find(root.left, k);
        return true;
    }
}