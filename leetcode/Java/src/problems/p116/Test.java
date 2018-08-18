package problems.p116;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        solution.connect(root);

        TreeLinkNode right = root.right;
    }
}
