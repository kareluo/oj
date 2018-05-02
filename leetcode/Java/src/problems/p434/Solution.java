package problems.p434;

class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean space = true;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch != ' ' && space) {
                count++;
                space = false;
            } else if (ch == ' ' && !space) {
                space = true;
            }
        }
        return count;
    }
}