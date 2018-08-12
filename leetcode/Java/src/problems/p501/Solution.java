package problems.p501;

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

    private int previous = Integer.MIN_VALUE;

    private int length = 0, max = 0;

    private List<Integer> values = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        values.clear();
        length = 0;
        find(root);
        int[] answers = new int[values.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = values.get(i);
        }
        return answers;
    }

    private void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (root.val > previous) {
            length = 1;
            previous = root.val;
        } else if (root.val == previous) {
            length++;
        }
        if (length > max) {
            max = length;
            values.clear();
            values.add(root.val);
        } else if (length == max) {
            values.add(root.val);
        }
        find(root.right);
    }
}