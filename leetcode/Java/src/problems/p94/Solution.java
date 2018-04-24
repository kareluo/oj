package problems.p94;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        Stack<Integer> ops = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();

        int op = 0;
        while (root != null) {
            if (op == 0) {
                if (root.left != null) {
                    stack.push(root);
                    ops.push(1);
                    op = 0;
                    root = root.left;
                } else {
                    traversal.add(root.val);
                    if (root.right != null) {
                        stack.push(root);
                        ops.push(2);
                        op = 0;
                        root = root.right;
                    } else {
                        if (!stack.isEmpty()) {
                            root = stack.pop();
                            op = ops.pop();
                        } else root = null;
                    }
                }
            } else if (op == 1) {
                traversal.add(root.val);
                if (root.right != null) {
                    stack.push(root);
                    ops.push(2);
                    op = 0;
                    root = root.right;
                } else {
                    if (!stack.isEmpty()) {
                        root = stack.pop();
                        op = ops.pop();
                    } else root = null;
                }
            } else {
                if (!stack.isEmpty()) {
                    root = stack.pop();
                    op = ops.pop();
                } else root = null;
            }
        }

        return traversal;
    }
}