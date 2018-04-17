package problems.p817;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public int numComponents(ListNode head, int[] G) {
        int[] link = new int[10000];
        Arrays.fill(link, -1);

        while (head != null) {
            link[head.val] = head.next != null ? head.next.val : head.val;
            head = head.next;
        }

        int[] fs = new int[10000];
        Arrays.fill(fs, -1);
        for (int g : G) {
            if (g < 10000 && link[g] != -1) {
                fs[g] = link[g];
            }
        }

        boolean[] vs = new boolean[10000];
        for (int g : G) {
            if (g < 10000 && fs[g] != -1) {
                vs[find(fs, g)] = true;
            }
        }

        int count = 0;
        for (boolean v : vs) {
            if (v) count++;
        }

        return count;
    }

    private static int find(int[] v, int j) {
        if (v[j] == -1 || v[j] == j) {
            return j;
        }
        return v[j] = find(v, v[j]);
    }
}