package problems.p234;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        int length = 0;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }

        length >>= 1;
        next = head;
        while (length-- > 0) {
            next = next.next;
        }

        ListNode tail = next, prv = null;
        while (next != null && next.next != null) {
            tail = next.next;
            next.next = prv;
            prv = next;
            next = tail;
        }
        tail.next = prv;

        while (head != null && tail != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }

        return true;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}