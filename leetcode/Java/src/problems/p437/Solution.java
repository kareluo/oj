package problems.p437;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

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

    private int paths = 0;

    private Map<Integer, Integer> sums = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        init();
        path(root, 0, sum);
        return paths;
    }

    private void init() {
        paths = 0;
        sums.clear();
        sums.put(0, 1);
    }

    private void path(TreeNode root, int sum, int target) {
        if (root == null) return;
        sum += root.val;
        paths += has(sum - target);
        inc(sum);
        path(root.left, sum, target);
        path(root.right, sum, target);
        dec(sum);
    }

    private int has(int value) {
        Integer v = sums.get(value);
        if (v != null) {
            return v;
        }
        return 0;
    }

    private void inc(int value) {
        Integer v = sums.get(value);
        if (v == null) v = 0;
        sums.put(value, v + 1);
    }

    private void dec(int value) {
        Integer v = sums.get(value);
        if (v == null) v = 0;
        sums.put(value, v - 1);
    }
}