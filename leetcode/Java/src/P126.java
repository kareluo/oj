import java.util.*;

/**
 * by felix 2018/03/20
 * <p>
 * 126. Word Ladder II
 * https://leetcode.com/problems/word-ladder-ii/description/
 */
public class P126 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        List<List<String>> results = solution.findLadders(beginWord, endWord, wordList);
        for (List<String> result : results) {
            System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
        }

        Solution2 solution2 = new Solution2();
        results = solution2.findLadders("hot", "dog", Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"));
        for (List<String> result : results) {
            System.out.println(Arrays.toString(result.toArray(new String[result.size()])));
        }
    }

    /**
     * 1. 先建立每个节点之间的联系，如果两个word 可以transform, 则认为其之间有一条距离为1的双向连接
     * 2. 使用Breadth first search，计算每个节点距离BeginWord 的最短距离，到EndWord时则停止
     * 3. 从EndWord 回溯到BeginWord，一条成功的路径上的节点即为一条解
     */
    static class Solution1 {

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

    static class Solution2 {

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
}

