package problems.p92;

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int next = 1;

        ListNode p = head, q = null;
        while (next < m) {
            next++;
            q = p;
            p = p.next;
        }

        ListNode temp, sub = null;
        while (next <= n) {
            temp = p.next;
            p.next = sub;
            sub = p;
            p = temp;
            next++;
        }

        if (q != null) {
            q.next.next = p;
            q.next = sub;
            return head;
        } else {
            head.next = p;
            return sub;
        }
    }
}