package problems.p160;

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = 0, lengthB = 0;
        ListNode pA = headA, pB = headB;
        while (pA != null) {
            lengthA++;
            pA = pA.next;
        }

        while (pB != null) {
            lengthB++;
            pB = pB.next;
        }

        pA = headA;
        pB = headB;
        if (lengthA > lengthB) {
            int step = lengthA - lengthB;
            while (step-- > 0) pA = pA.next;
        } else {
            int step = lengthB - lengthA;
            while (step-- > 0) pB = pB.next;
        }

        ListNode p = null;
        while (pA != null && pB != null) {
            if (pA.val == pB.val) {
                if (p == null) p = pA;
            } else {
                p = null;
            }

            pA = pA.next;
            pB = pB.next;
        }

        return p;
    }
}