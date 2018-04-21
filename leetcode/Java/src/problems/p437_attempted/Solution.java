package problems.p437_attempted;

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

    public int pathSum(TreeNode root, int sum) {
        int[] sums = new int[1000];

        int n = pathSum(root, sum, 0, 0, sums, new int[1000]);

        int paths = 0;
        for (int i = 0; i < n; i++) {
            paths += sums[i];
        }

        return paths;
    }

    private int pathSum(TreeNode root, int sum, int curSum, int num, int[] sums, int[] children) {
        if (root == null) {
            return 0;
        }

        if (curSum + root.val == sum) {
            sums[num]++;
        }

        if (curSum == 0 && children[num] > 0) {
            return children[num];
        }

        int lChildren = pathSum(root.left, sum, 0, num + 1, sums, children);
        pathSum(root.left, sum, curSum + root.val, num + 1, sums, children);

        int rChildren = pathSum(root.right, sum, 0, num + 1 + lChildren, sums, children);
        pathSum(root.right, sum, curSum + root.val, num + 1 + lChildren, sums, children);

        return children[num] = lChildren + rChildren + 1;
    }
}