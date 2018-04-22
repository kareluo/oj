package problems.p160;

import common.ListNode;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        print(solution.getIntersectionNode(build(new int[]{1, 2, 3, 4, 5}), build(new int[]{1, 2, 3, 4, 5})));
        print(solution.getIntersectionNode(build(new int[]{1, 2, 3, 4, 5}), build(new int[]{1})));
        print(solution.getIntersectionNode(build(new int[]{1, 2, 3, 4, 5}), build(new int[]{3, 4})));
        print(solution.getIntersectionNode(build(new int[]{1, 2, 3, 4, 5}), build(new int[]{3, 4, 5})));
        print(solution.getIntersectionNode(build(new int[]{}), build(new int[]{})));
        print(solution.getIntersectionNode(build(new int[]{}), build(new int[]{1})));
        print(solution.getIntersectionNode(build(new int[]{1}), build(new int[]{1})));
        print(solution.getIntersectionNode(build(new int[]{1}), build(new int[]{})));
    }

    private static ListNode build(int[] vals) {
        return build(vals, 0);
    }

    private static ListNode build(int[] vals, int index) {
        if (index >= vals.length) return null;
        ListNode node = new ListNode(vals[index]);
        node.next = build(vals, index + 1);
        return node;
    }

    private static void print(ListNode node) {
        if (node == null) return;
        if (node.next != null) {
            System.out.print(node.val + " -> ");
            print(node.next);
        } else {
            System.out.println(node.val);
        }
    }
}
