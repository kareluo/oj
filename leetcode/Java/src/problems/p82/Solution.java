package problems.p82;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        boolean duplicate = false;
        while (head.next != null && head.next.val == head.val) {
            head.next = head.next.next;
            duplicate = true;
        }
        if (duplicate) {
            return deleteDuplicates(head.next);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }
}