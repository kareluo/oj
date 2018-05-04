package problems.p784;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> letterCasePermutation(String S) {
        char[] chars = S.toCharArray();
        int[] next = new int[chars.length];
        char[] toChars = new char[chars.length];
        List<String> letters = new ArrayList<>();
        int index = chars.length;
        for (int i = index - 1; i >= 0; i--) {
            char ch = chars[i];
            if (ch >= 'A' && ch <= 'Z') {
                toChars[i] = (char) (ch + 32);
                next[i] = index;
                index = i;
            } else if (ch >= 'a' && ch <= 'z') {
                toChars[i] = (char) (ch - 32);
                next[i] = index;
                index = i;
            }
        }
        letters(letters, chars, index, next, toChars);
        return letters;
    }

    private void letters(List<String> letters, char[] chars, int index, int[] next, char[] toChars) {
        if (index >= chars.length) {
            letters.add(String.valueOf(chars));
            return;
        }
        letters(letters, chars, next[index], next, toChars);
        char ch = chars[index];
        chars[index] = toChars[index];
        letters(letters, chars, next[index], next, toChars);
        chars[index] = ch;
    }
}