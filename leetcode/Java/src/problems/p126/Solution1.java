package problems.p126;

import java.util.*;

/**
 * 1. 先建立每个节点之间的联系，如果两个word 可以transform, 则认为其之间有一条距离为1的双向连接
 * 2. 使用Breadth first search，计算每个节点距离BeginWord 的最短距离，到EndWord时则停止
 * 3. 从EndWord 回溯到BeginWord，一条成功的路径上的节点即为一条解
 */
class Solution1 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty()
                || beginWord == null || endWord == null) {
            return Collections.emptyList();
        }

        Word eWord = null;
        List<Word> words = new ArrayList<>(wordList.size());
        for (String word : wordList) {
            Word wd = new Word(word);
            if (word.equals(endWord)) {
                eWord = wd;
            }
            for (Word w : words) {
                if (Word.canTransform(w.word, wd.word)) {
                    w.words.add(wd);
                    wd.words.add(w);
                }
            }
            words.add(wd);
        }

        if (eWord == null) {
            return new LinkedList<>();
        }

        Word bWord = new Word(beginWord);
        for (Word wn : words) {
            if (Word.canTransform(wn.word, bWord.word)) {
                wn.words.add(bWord);
                bWord.words.add(wn);
            }
        }

        breadthSearch(bWord, eWord);

        List<List<String>> results = new LinkedList<>();
        if (eWord.len < Integer.MAX_VALUE) {
            assembleResults(results, new LinkedList<>(), eWord);
        }

        return results;
    }

    private void breadthSearch(Word bWord, Word eWord) {
        bWord.len = 0;
        Queue<Word> words = new ArrayDeque<>();
        for (Word word : bWord.words) {
            word.len = 1;
            words.add(word);
        }

        while (!words.isEmpty()) {
            Word word = words.poll();
            if (word == eWord) {
                break;
            }
            int len = word.len;
            for (Word w : word.words) {
                if (w.len - 1 > len) {
                    w.len = len + 1;
                    words.add(w);
                }
            }
        }
    }

    private void assembleResults(List<List<String>> results, List<String> result, Word word) {
        result.add(0, word.word);
        if (word.len == 0) {
            results.add(result);
            return;
        }
        for (Word w : word.words) {
            if (w.len == word.len - 1) {
                assembleResults(results, new LinkedList<>(result), w);
            }
        }
    }

    static class Word {

        String word;

        int len = Integer.MAX_VALUE;

        List<Word> words = new LinkedList<>();

        Word(String word) {
            this.word = word;
        }

        static boolean canTransform(String word1, String word2) {
            int n = 0;
            for (int i = word1.length() - 1; i >= 0; i--) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    if (n++ > 0) return false;
                }
            }
            return n == 1;
        }
    }
}