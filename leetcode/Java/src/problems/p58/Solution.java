package problems.p58;

class Solution {
    public int lengthOfLastWord(String s) {
        int i, count = 0;
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count > 0) break;
        }
        return count;
    }
}