package problems.p530;

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

    private int value;

    private int min = Integer.MAX_VALUE;

    private boolean first = true;

    public int getMinimumDifference(TreeNode root) {
        first = true;
        min = Integer.MAX_VALUE;
        travel(root);
        return min;
    }

    private void travel(TreeNode root) {
        if (root == null) return;
        travel(root.left);
        if (first) {
            first = false;
            value = root.val;
        } else {
            if (root.val - value < min) {
                min = root.val - value;
            }
            value = root.val;
        }
        travel(root.right);
    }
}