package problems.p744;

import java.util.Arrays;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z') return letters[0];
        int i = Arrays.binarySearch(letters, target);
        if (i >= 0) {
            i = Arrays.binarySearch(letters, i, letters.length, (char) (target + 1));
            if (i >= 0) return letters[i];
        }
        return letters[(-i - 1) % letters.length];
    }
}