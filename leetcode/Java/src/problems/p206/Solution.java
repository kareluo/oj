package problems.p206;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode h = rev(head, head);
        return h != null ? h.next : null;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, p;
        while (head != null) {
            p = head.next;
            head.next = pre;
            pre = head;
            head = p;
        }
        return pre;
    }

    private ListNode rev(ListNode head, ListNode node) {
        if (node == null) return null;
        ListNode p = rev(head, node.next);
        if (p != null) {
            p.next = head;
        } else {
            head.next = node;
        }
        return head;
    }
}