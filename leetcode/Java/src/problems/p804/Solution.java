package problems.p804;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private static String[] sMorse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-", "..-",
            "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> vs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.delete(0, sb.length());
            for (int i = 0; i < word.length(); i++) {
                sb.append(sMorse[word.charAt(i) - 'a']);
            }
            vs.add(sb.toString());
        }
        return vs.size();
    }
}