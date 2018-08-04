package problems.p863;

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

    private List<Integer> nodes = new LinkedList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        searchTarget(root, target, 0, K);
        return nodes;
    }

    private int searchTarget(TreeNode root, TreeNode target, int index, int K) {
        if (root == null) return -1;
        if (root == target) {
            search(root, K);
            return index;
        }
        int i = searchTarget(root.left, target, index + 1, K);
        if (i >= 0) {
            if (i - index == K) {
                nodes.add(root.val);
            }
            search(root.right, K - i + index - 1);
        }
        int j = searchTarget(root.right, target, index + 1, K);
        if (j >= 0) {
            if (j - index == K) {
                nodes.add(root.val);
            }
            search(root.left, K - j + index - 1);
        }
        return Math.max(i, j);
    }

    private void search(TreeNode root, int step) {
        if (root == null || step < 0) return;
        if (step == 0) {
            nodes.add(root.val);
        } else {
            search(root.left, step - 1);
            search(root.right, step - 1);
        }
    }
}