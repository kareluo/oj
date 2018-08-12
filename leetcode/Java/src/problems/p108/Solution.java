package problems.p108;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int begin, int end) {
        if (begin >= end) return null;
        int mid = (end + begin) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, begin, mid);
        root.right = build(nums, mid + 1, end);
        return root;
    }
}