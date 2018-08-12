package problems.p653;

import common.TreeNode;

import java.util.Stack;

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

    private Stack<Integer> stacks = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (findTarget(root.left, k)) {
            return true;
        }
        while (!stacks.isEmpty()) {
            Integer value = stacks.peek();
            if (value >= root.val) {
                if (value == root.val) {
                    return true;
                }
                break;
            }
            stacks.pop();
        }
        if (k - root.val >= root.val) {
            stacks.push(k - root.val);
        }
        return !stacks.isEmpty() && findTarget(root.right, k);
    }
}