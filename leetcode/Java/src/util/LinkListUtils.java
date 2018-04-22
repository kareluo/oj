package util;

import common.ListNode;

public class LinkListUtils {

    public static ListNode build(int[] vals) {
        return build(vals, 0);
    }

    public static ListNode build(int[] vals, int index) {
        if (index >= vals.length) return null;
        ListNode node = new ListNode(vals[index]);
        node.next = build(vals, index + 1);
        return node;
    }

    public static void println(ListNode node) {
        print(node);
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
