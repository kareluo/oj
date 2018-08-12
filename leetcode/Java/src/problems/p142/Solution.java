package problems.p142;

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
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;

        while (q != null && p.next != null) {
            if (q == p.next || q == p.next.next) {
                break;
            }
            q = q.next;
            p = p.next.next;
            if (p == null) {
                return null;
            }
        }

        if (q == null || p.next == null) {
            return null;
        }

        int size = 0;
        p = q.next;
        while (q != p) {
            size++;
            p = p.next;
        }

        p = q = head;
        while (size-- > 0) {
            p = p.next;
        }

        while (q != p.next) {
            p = p.next;
            q = q.next;
        }

        return q;
    }
}