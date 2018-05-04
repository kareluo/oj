package problems.p257;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        travel(root, paths, new StringBuilder());
        return paths;
    }

    private void travel(TreeNode root, List<String> paths, StringBuilder sb) {
        if (root == null) return;
        int index = sb.length();
        sb.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(sb.substring(2));
        } else {
            travel(root.left, paths, sb);
            travel(root.right, paths, sb);
        }
        sb.delete(index, sb.length());
    }
}