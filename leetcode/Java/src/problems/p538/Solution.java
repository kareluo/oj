package problems.p538;

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
    public TreeNode convertBST(TreeNode root) {
        sum(root, 0);
        return root;
    }

    private int sum(TreeNode root, int sum) {
        if (root == null) return 0;

        int tSum = root.val;

        int rSum = sum(root.right, sum);

        root.val += rSum + sum;

        tSum += sum(root.left, root.val) + rSum;

        return tSum;
    }
}