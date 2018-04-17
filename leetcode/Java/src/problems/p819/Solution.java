package problems.p819;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("!|\\?|'|,|;|\\.", " ");
        paragraph = paragraph.replaceAll("(  +)", " ");

        System.out.println(paragraph);
        String[] words = paragraph.split(" ");
        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            Integer count = 0;
            if (counts.containsKey(word)) {
                count = counts.get(word);
            }
            counts.put(word, count + 1);
        }

        for (String bd : banned) {
            counts.remove(bd);
        }

        int max = 0;
        String word = "";
        Set<Map.Entry<String, Integer>> entries = counts.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                word = entry.getKey();
            }
        }

        return word;
    }
}