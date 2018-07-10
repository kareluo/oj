package problems.p830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> groups = new ArrayList<>();
        char[] chars = S.toCharArray();
        int starting = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[starting] != chars[i]) {
                if (i - starting >= 3) {
                    groups.add(Arrays.asList(starting, i - 1));
                }
                starting = i;
            }
        }

        if (chars.length - starting >= 3) {
            groups.add(Arrays.asList(starting, chars.length - 1));
        }

        return groups;
    }
}