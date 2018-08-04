package problems.p429;

import common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> orders = new LinkedList<>();
        if (root == null) {
            return orders;
        }
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> level = new LinkedList<>();
            while (size-- > 0) {
                Node poll = nodes.poll();
                level.add(poll.val);
                if (poll.children != null) {
                    nodes.addAll(poll.children);
                }
            }
            orders.add(level);
        }
        return orders;
    }
}