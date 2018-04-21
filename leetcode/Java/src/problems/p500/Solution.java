package problems.p500;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] POS = new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3, 2, 1,
            2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2,
            1, 1, 3, 1, 3, 1, 3, 0, 0, 0, 0, 0, 0, 2,
            3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1,
            1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3, 0, 0, 0
    };

    public String[] findWords(String[] words) {
        int position, i, length;
        List<String> ws = new ArrayList<>(words.length);
        for (String word : words) {
            length = word.length();
            if (length == 0) {
                ws.add(word);
                continue;
            }
            position = POS[word.charAt(0)];
            for (i = 1; i < length; i++) {
                if (position != POS[word.charAt(i)]) {
                    break;
                }
            }
            if (i >= length) ws.add(word);
        }
        return ws.toArray(new String[ws.size()]);
    }
}