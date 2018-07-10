package problems.p450;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {

            TreeNode left = left(root.right);
            if (left != null) {
                root.val = left.val;
            }
        } else {
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        }
        return root;
    }

    private void deleteNode(TreeNode root) {
        if (root == null) return;
//        if (root.val == key) {
//            if (root.left == null)
//        }
    }

    private TreeNode left(TreeNode root) {
        if (root == null) return null;
        if (root.left == null) {
            return root;
        }
        return left(root.left);
    }

    private TreeNode right(TreeNode root) {
        if (root == null) return null;
        if (root.right == null) {
            return root;
        }
        return right(root.right);
    }


}