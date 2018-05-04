package problems.p563;

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
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        travel(root, tilt);
        return tilt[0];
    }

    private int travel(TreeNode root, int[] tilts) {
        if (root == null) return 0;
        int lHeight = travel(root.left, tilts);
        int rHeight = travel(root.right, tilts);
        tilts[0] += Math.abs(lHeight - rHeight);
        return lHeight + rHeight + root.val;
    }
}