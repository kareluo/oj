package problems.p203;

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode _head = new ListNode(0);
        _head.next = head;
        ListNode p = head, pre = _head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }
        return _head.next;
    }
}