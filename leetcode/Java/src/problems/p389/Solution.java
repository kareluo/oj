package problems.p389;

class Solution {
    public char findTheDifference(String s, String t) {
        char ch = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) ch ^= c;
        chars = t.toCharArray();
        for (char c : chars) ch ^= c;
        return ch;
    }
}