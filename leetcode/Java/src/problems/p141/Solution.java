package problems.p141;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p = head, q = head.next;
        while (p != null && q != null) {
            if (p == q || p == q.next) {
                return true;
            }
            p = p.next;
            if (q.next != null) {
                q = q.next.next;
            } else break;
        }
        return false;
    }
}