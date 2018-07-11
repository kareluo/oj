package problems.p105;

import common.TreeNode;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0);
    }

    private TreeNode build(int[] preorder, int[] inorder, int begin, int end, int index) {
        if (end < begin) return null;
        int b;
        for (b = begin; b <= end; b++)
            if (inorder[b] == preorder[index])
                break;
        TreeNode node = new TreeNode(preorder[index]);
        node.left = build(preorder, inorder, begin, b - 1, index + 1);
        node.right = build(preorder, inorder, b + 1, end, index + b - begin + 1);
        return node;
    }
}