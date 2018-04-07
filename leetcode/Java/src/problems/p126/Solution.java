package problems.p126;

import java.util.*;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty()
                || beginWord == null || endWord == null) {
            return Collections.emptyList();
        }

        HashMap<String, Integer> words = new HashMap<>();
        for (String word : wordList) {
            words.put(word, Integer.MAX_VALUE);
        }
        words.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int i, j, len;
        char ch, chars[];
        String next;
        boolean doing = true;
        while (doing && !queue.isEmpty()) {
            String word = queue.poll();
            if (word.equals(endWord)) break;
            len = words.get(word);
            chars = word.toCharArray();
            for (i = 0; i < chars.length; i++) {
                ch = chars[i];
                for (j = 'a'; j <= 'z'; j++) {
                    if (j == ch) continue;
                    chars[i] = (char) j;
                    next = new String(chars);
                    if (words.containsKey(next) && len < words.get(next) - 1) {
                        words.put(next, len + 1);
                        if (next.equals(endWord)) {
                            doing = false;
                            break;
                        }
                        queue.offer(next);
                    }
                }
                if (!doing) break;
                chars[i] = ch;
            }
        }

        List<List<String>> results = new LinkedList<>();
        if (words.get(endWord) < Integer.MAX_VALUE) {
            getResults(words.get(endWord), endWord, new LinkedList<>(), results, words, beginWord);
        }
        return results;
    }

    private static void getResults(int length,
                                   String word,
                                   List<String> result,
                                   List<List<String>> results,
                                   Map<String, Integer> words,
                                   String beginWord) {
        result.add(word);
        if (beginWord.equals(word)) {
            results.add(result);
            return;
        }

        char ch;
        String next;
        char[] chars = word.toCharArray();
        for (int i = 0, j; i < chars.length; i++) {
            ch = chars[i];
            for (j = 'a'; j <= 'z'; j++) {
                if (ch == j) continue;
                chars[i] = (char) j;
                next = new String(chars);
                if (words.containsKey(next)) {
                    if (length - 1 == words.get(next)) {
                        getResults(length - 1, next,
                                new LinkedList<>(result), results,
                                words, beginWord
                        );
                    }
                }
            }
            chars[i] = ch;
        }
    }
}
