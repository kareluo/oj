package problems.p589;

import common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

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
    public List<Integer> preorder(Node root) {
        List<Integer> orders = new LinkedList<>();
        if (root == null) {
            return orders;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            orders.add(node.val);
            if (node.children != null) {
                ListIterator<Node> itr = node.children.listIterator(node.children.size());
                while (itr.hasPrevious()) {
                    nodes.add(itr.previous());
                }
            }
        }
        return orders;
    }
}