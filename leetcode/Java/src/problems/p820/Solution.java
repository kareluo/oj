package problems.p820;

class Solution {

    private static class WordTreeNode {
        WordTreeNode[] words = new WordTreeNode[26];
    }

    public int minimumLengthEncoding(String[] words) {
        WordTreeNode root = new WordTreeNode();
        for (String word : words) {
            int index = word.charAt(word.length() - 1) - 'a';
            root.words[index] = build(root.words[index], word, word.length() - 1);
        }

        int[] height = new int[1];
        height(root, height, 1);

        return height[0];
    }

    private void height(WordTreeNode root, int[] height, int h) {
        if (root == null) {
            return;
        }

        boolean isLeaf = true;
        for (int i = 0; i < 26; i++) {
            if (root.words[i] != null) {
                isLeaf = false;
                height(root.words[i], height, h + 1);
            }
        }

        if (isLeaf) {
            height[0] += h;
        }
    }

    private WordTreeNode build(WordTreeNode root, String word, int index) {
        if (root == null) root = new WordTreeNode();
        if (index > 0) {
            root.words[word.charAt(index - 1) - 'a'] =
                    build(root.words[word.charAt(index - 1) - 'a'], word, index - 1);
        }
        return root;
    }
}