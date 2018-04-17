package problems.p817;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = build(new int[]{0, 1, 2, 3}, 0);

        System.out.println(solution.numComponents(head, new int[]{0, 1, 3}));
    }

    public static ListNode build(int[] values, int index) {
        if (index < values.length) {
            ListNode node = new ListNode(values[index]);
            node.next = build(values, index + 1);
            return node;
        }
        return null;
    }
}
