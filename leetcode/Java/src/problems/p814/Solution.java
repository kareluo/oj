package problems.p814;

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

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left = pruneTree(root.left);
        }

        if (root.right != null) {
            root.right = pruneTree(root.right);
        }

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}