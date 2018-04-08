package problems.p456_attempted;

class Solution {

    private boolean mResult = false;

    private static class TreeNode {

        int min, depth;

        int begin, end;

        TreeNode lChild = null;

        TreeNode rChild = null;

        public TreeNode(int value) {
            this.depth = 0;
            this.min = value;
            this.begin = this.end = value;
        }

        int balance() {
            int balance = 0;
            if (lChild != null) {
                balance = lChild.depth;
            }

            if (rChild != null) {
                balance = rChild.depth;
            }
            return balance;
        }

        void reDepth() {
            depth = 0;
            if (lChild != null) {
                depth = lChild.depth + 1;
            }

            if (rChild != null && depth < rChild.depth + 1) {
                depth = rChild.depth + 1;
            }
        }
    }

    public boolean find132pattern(int[] nums) {

        mResult = false;
        if (nums.length < 3) {
            return false;
        }

        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            insert(root, nums[i]);
            if (mResult) {
                return mResult;
            }
        }
        return mResult;
    }

    private TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (root.begin < value && root.end > value) {
            mResult = true;
            return root;
        }

        if (value > root.end) {
            root.end = value;
            if (root.lChild != null) {
                root.begin = root.lChild.min;
            }
            root.lChild = null;
            root.rChild = insert(root.rChild, value);

//            doBalanceAdjust(root);

            return root;
        } else if (value < root.begin) {
            root.lChild = insert(root.lChild, value);

            if (root.lChild.min < root.min) {
                root.min = root.lChild.min;
            }

            if (root.rChild != null) {
                root.depth = root.rChild.depth;
            }

            if (root.depth < root.lChild.depth) {
                root.depth = root.lChild.depth;
            }

            root.depth++;

            // 平衡调整

        } else {
            mResult = true;
        }
        return null;
    }

    private TreeNode doBalanceAdjust(TreeNode root, int balance) {
        do {
            int b = root.balance();
            if (b < -1) {
                root.rChild = doBalanceAdjust(root.rChild, b);
                root.reDepth();
            } else if (b > 1) {
                root.lChild = doBalanceAdjust(root.lChild, b);
                root.reDepth();
            }

            b = root.balance();
            if (b == -1) {
                TreeNode nRoot = root.rChild;

                root.rChild = nRoot.lChild;
                root.reDepth();

                nRoot.lChild = root;
                nRoot.reDepth();

                root = nRoot;
            } else if (b > 1) {
                TreeNode nRoot = root.lChild;

                root.lChild = nRoot.rChild;
                root.reDepth();

                nRoot.rChild = root;
                nRoot.reDepth();

                root = nRoot;
            }
        } while (Math.abs(root.balance()) > 1);

        return root;
    }
}