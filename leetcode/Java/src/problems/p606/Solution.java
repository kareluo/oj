package problems.p606;

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

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t != null) travel(t, sb);
        return sb.toString();
    }

    private void travel(TreeNode root, StringBuilder sb) {
        sb.append(root.val);

        if (root.left != null) {
            sb.append("(");
            travel(root.left, sb);
            sb.append(")");
        } else if (root.right != null) {
            sb.append("()");
        }

        if (root.right != null) {
            sb.append("(");
            travel(root.right, sb);
            sb.append(")");
        }
    }
}