package problems.p144;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

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

    private List<Integer> orders = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return orders;
        }
        orders.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return orders;
    }
}