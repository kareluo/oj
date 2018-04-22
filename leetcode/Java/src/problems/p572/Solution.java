package problems.p572;

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return t == null && s == null || t != null && s != null
                && (isSameRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isSameRoot(TreeNode s, TreeNode t) {
        return t == null && s == null || t != null && s != null
                && s.val == t.val && isSameRoot(s.left, t.left) && isSameRoot(s.right, t.right);
    }
}