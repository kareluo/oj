package problems.p654;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = null;
        for (int num : nums)
            root = insert(root, num);
        return root;
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value > root.val) {
            TreeNode node = new TreeNode(value);
            node.left = root;
            return node;
        } else {
            root.right = insert(root.right, value);
            return root;
        }
    }
}