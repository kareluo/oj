package problems.p19;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = null;
        while (p != null) {
            if (n == 0) {
                q = head;
            } else if (n < 0) {
                q = q.next;
            }
            p = p.next;
            n--;
        }
        if (q != null && q.next != null) {
            q.next = q.next.next;
            return head;
        } else {
            return head.next;
        }
    }
}