package problems.p107;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> travels = new ArrayList<>();
        travel(travels, root, 0);
        Collections.reverse(travels);
        return travels;
    }

    private void travel(List<List<Integer>> travels, TreeNode root, int level) {
        if (root == null) return;
        if (travels.size() == level) {
            travels.add(new ArrayList<>());
        }

        travel(travels, root.left, level + 1);
        travels.get(level).add(root.val);
        travel(travels, root.right, level + 1);
    }
}