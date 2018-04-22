package problems.p23;

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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int begin, int end) {
        if (begin > end) return null;
        if (begin == end) return lists[begin];
        int mid = (end + begin) >> 1;
        return merge(merge(lists, begin, mid), merge(lists, mid + 1, end));
    }

    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode head;
        if (a.val < b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }
        ListNode p = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                p.next = a;
                p = a;
                a = a.next;
            } else {
                p.next = b;
                p = b;
                b = b.next;
            }
        }

        if (a == null) p.next = b;
        if (b == null) p.next = a;

        return head;
    }
}