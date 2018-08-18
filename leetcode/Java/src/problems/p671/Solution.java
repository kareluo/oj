package problems.p671;

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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        int value = findSecondValue(root, root.val);
        return root.val == value ? -1 : value;
    }

    private int findSecondValue(TreeNode root, int value) {
        if (root == null) return value;
        if (root.val > value) {
            return root.val;
        }
        int left = findSecondValue(root.left, value);
        int right = findSecondValue(root.right, value);
        if (left == value) {
            return right;
        } else if (right == value) {
            return left;
        } else return Math.min(left, right);
    }
}