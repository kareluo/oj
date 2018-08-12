package problems.p24;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode q, p = root;
        while (p.next != null && p.next.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = p.next.next;
            p.next.next = q;
            p = p.next.next;
        }
        return root.next;
    }
}