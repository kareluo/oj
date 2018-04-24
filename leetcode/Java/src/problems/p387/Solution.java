package problems.p387;

class Solution {
    public int firstUniqChar(String s) {
        int[] counts = new int[255];
        char[] chars = s.toCharArray();
        for (char ch : chars) counts[ch]++;
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}