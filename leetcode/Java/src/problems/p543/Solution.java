package problems.p543;

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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxp = new int[]{1};
        heightOfTree(root, maxp);
        return maxp[0] - 1;
    }

    private int heightOfTree(TreeNode root, int[] maxp) {
        if (root == null) return 0;
        int lh = heightOfTree(root.left, maxp);
        int rh = heightOfTree(root.right, maxp);
        if (maxp[0] < lh + rh + 1) {
            maxp[0] = lh + rh + 1;
        }
        return Math.max(lh, rh) + 1;
    }
}