package problems.p116;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    private TreeLinkNode previous;

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        for (int level = 0; ; level++) {
            previous = null;
            connect(root, level);
            if (previous == null) {
                break;
            }
        }
    }

    private void connect(TreeLinkNode root, int level) {
        if (root == null || level < 0) return;
        if (level == 0) {
            root.next = previous;
            previous = root;
            return;
        }
        connect(root.right, level - 1);
        connect(root.left, level - 1);
    }
}

class TreeLinkNode {

    int val;

    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}