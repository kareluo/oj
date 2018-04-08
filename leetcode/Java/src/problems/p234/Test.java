package problems.p234;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);

        System.out.println(solution.isPalindrome(node));

    }
}
