package problems.p590;

import java.util.LinkedList;
import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> values = new LinkedList<>();
        TreeNode head = null;
        if (root != null) head = new TreeNode(root);
        while (head != null) {
            values.add(0, head.node.val);
            if (head.node.children != null) {
                for (Node node : head.node.children) {
                    head.insert(new TreeNode(node));
                }
            }
            head = head.next;
        }
        return values;
    }

    private static class TreeNode {
        Node node;
        TreeNode next;

        public TreeNode(Node node) {
            this.node = node;
        }

        public TreeNode(Node node, TreeNode next) {
            this.node = node;
            this.next = next;
        }

        void insert(TreeNode node) {
            node.next = next;
            next = node;
        }
    }
}

class Node {
    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}