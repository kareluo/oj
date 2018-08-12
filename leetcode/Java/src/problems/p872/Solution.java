package problems.p872;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> leaves = new LinkedList<>();
        obtainLeaves(root1, leaves);
        return testLeaves(root2, leaves) && leaves.isEmpty();
    }

    private void obtainLeaves(TreeNode root, Queue<Integer> leaves) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        obtainLeaves(root.left, leaves);
        obtainLeaves(root.right, leaves);
    }

    private boolean testLeaves(TreeNode root, Queue<Integer> leaves) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return !leaves.isEmpty() && root.val == leaves.poll();
        }
        return testLeaves(root.left, leaves) && testLeaves(root.right, leaves);
    }
}