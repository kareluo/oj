package problems.p113;

import common.TreeNode;

import java.util.ArrayList;
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

    private List<List<Integer>> values = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        values.clear();
        search(root, new ArrayList<>(), 0, sum);
        return values;
    }

    private void search(TreeNode root, List<Integer> paths, int sum, int target) {
        if (root == null) return;
        sum += root.val;
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                values.add(new ArrayList<>(paths));
            }
            paths.remove(paths.size() - 1);
            return;
        }
        search(root.left, paths, sum, target);
        search(root.right, paths, sum, target);
        paths.remove(paths.size() - 1);
    }
}