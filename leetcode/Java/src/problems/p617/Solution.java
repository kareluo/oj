package problems.p617;

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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 != null && t2 != null) {
            return merge(t1, t2);
        }

        if (t1 != null) {
            return t1;
        }

        return t2;
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        TreeNode node = new TreeNode(t1.val + t2.val);
        if (t1.left != null && t2.left != null) {
            node.left = merge(t1.left, t2.left);
        } else if (t1.left != null) {
            node.left = t1.left;
        } else if (t2.left != null) {
            node.left = t2.left;
        }

        if (t1.right != null && t2.right != null) {
            node.right = merge(t1.right, t2.right);
        } else if (t1.right != null) {
            node.right = t1.right;
        } else if (t2.right != null) {
            node.right = t2.right;
        }

        return node;
    }
}

/**
 * 调用栈会教第一种多些
 */
class Solution2 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}