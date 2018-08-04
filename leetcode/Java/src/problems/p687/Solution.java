package problems.p687;

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

    private int length;

    public int longestUnivaluePath(TreeNode root) {
        length = 1;
        if (root != null) {
            search(root, root.val + 1);
        }
        return length - 1;
    }

    private int search(TreeNode root, int val) {
        if (root == null) return 0;
        int left = search(root.left, root.val);
        int right = search(root.right, root.val);
        if (left + right + 1 > length) {
            length = left + right + 1;
        }
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}