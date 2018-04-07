package problems.p126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution2 {

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

        dijkstra(bWord, eWord, words.size());

        List<List<String>> results = new LinkedList<>();
        if (eWord.len < Integer.MAX_VALUE) {
            assembleResults(results, new LinkedList<>(), eWord);
        }

        return results;
    }

    private void dijkstra(Word bWord, Word eWord, int size) {
        Heap heap = new Heap(size);

        bWord.len = 0;
        heap.add(bWord);

        Word pop;
        while (!heap.isEmpty()) {
            pop = heap.pop();
            if (pop == eWord) {
                break;
            }
            for (Word w : pop.words) {
                if (w.len - pop.len > 1) {
                    w.len = pop.len + 1;
                    heap.add(w);
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

    private static class Heap {

        int count;

        Word[] words;

        public Heap(int size) {
            count = 0;
            words = new Word[size];
        }

        void add(Word word) {
            int index = count;
            words[count++] = word;
            Word tempWord;
            while (words[index].len < words[index >> 1].len) {
                tempWord = words[index];
                words[index] = words[index >> 1];
                words[index >> 1] = tempWord;
                index >>= 1;
            }
        }

        Word pop() {
            Word word = words[0];
            words[0] = words[--count];

            Word tempWord;
            int index = 0, toIndex, lChild, rChild;
            while (index < count) {
                toIndex = index;
                lChild = index << 1;
                if (lChild < count && words[index].len > words[lChild].len) {
                    toIndex = lChild;
                }
                rChild = lChild + 1;
                if (rChild < count && words[toIndex].len > words[rChild].len) {
                    toIndex = rChild;
                }
                if (index == toIndex) break;

                tempWord = words[index];
                words[index] = words[toIndex];
                words[toIndex] = tempWord;
                index = toIndex;
            }

            return word;
        }

        boolean isEmpty() {
            return count == 0;
        }
    }
}