package problems.p17;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static String[] letters = new String[]{
            " ", "*", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
    };

    private List<String> words = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        words.clear();
        if (digits == null || digits.isEmpty()) {
            return words;
        }
        travel(digits, 0, new char[digits.length()]);
        return words;
    }

    private void travel(String digits, int i, char[] letter) {
        if (i >= digits.length()) {
            words.add(String.valueOf(letter));
            return;
        }
        char c = digits.charAt(i);
        String s = letters[c - '0'];
        for (int j = 0; j < s.length(); j++) {
            letter[i] = s.charAt(j);
            travel(digits, i + 1, letter);
        }
    }
}