package problems.p142;

import common.ListNode;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = head.next;
        System.out.println(solution.detectCycle(head));
    }
}
