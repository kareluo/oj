package problems.p23;

import common.ListNode;
import util.LinkListUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        LinkListUtils.println(solution.mergeKLists(new ListNode[]{
                null,
                LinkListUtils.build(new int[]{-1, 5, 11}),
                null,
                LinkListUtils.build(new int[]{6, 10})
        }));
    }
}
