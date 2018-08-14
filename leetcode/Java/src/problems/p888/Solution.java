package problems.p888;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" +");
        String[] wordsB = B.split(" +");
        Map<String, Integer> words = new HashMap<>();
        for (String word : wordsA) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        for (String word : wordsB) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<String> unCommons = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 1) {
                unCommons.add(entry.getKey());
            }
        }
        return unCommons.toArray(new String[unCommons.size()]);
    }
}