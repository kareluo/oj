package problems.p147;

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
    public ListNode insertionSortList(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode q = node;
            while (q.next != null && p.val >= q.next.val) {
                q = q.next;
            }
            ListNode x = p;
            p = p.next;
            x.next = q.next;
            q.next = x;
        }
        return node.next;
    }
}