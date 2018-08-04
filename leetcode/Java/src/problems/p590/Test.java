package problems.p590;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node head = new Node(1,
                Arrays.asList(
                        new Node(
                                3,
                                Arrays.asList(
                                        new Node(5, null),
                                        new Node(6, null)
                                )
                        ),
                        new Node(2, null),
                        new Node(4, null)
                ));
        solution.postorder(head);
    }
}
