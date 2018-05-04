package problems.p520;

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }

        int capital = 0;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (ch >= 'A' && ch <= 'Z') {
                capital++;
            } else if (capital > 1) {
                break;
            }
        }

        return capital == 0 || capital == chars.length || capital == 1 && chars[0] >= 'A' && chars[0] <= 'Z';
    }
}