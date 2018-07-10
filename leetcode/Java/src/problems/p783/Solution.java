package problems.p783;

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
    public int minDiffInBST(TreeNode root) {
        return Math.min(travelLeft(root.left, root.val),
                travelRight(root.right, root.val));
    }

    private int travelLeft(TreeNode root, int val) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(val - root.val,
                Math.min(travelLeft(root.left, root.val), travel(root.right, root.val, val)));
    }

    private int travelRight(TreeNode root, int val) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.val - val,
                Math.min(travel(root.left, val, root.val), travelRight(root.right, root.val)));
    }

    private int travel(TreeNode root, int minVal, int maxVal) {
        if (root == null) return Integer.MAX_VALUE;
        int dist = Math.min(root.val - minVal, maxVal - root.val);
        dist = Math.min(dist, travel(root.left, minVal, root.val));
        dist = Math.min(dist, travel(root.right, root.val, maxVal));
        return dist;
    }
}