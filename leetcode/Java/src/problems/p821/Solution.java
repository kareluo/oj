package problems.p821;

class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] dist = new int[S.length()];
        int pre = -100000, next = findNext(chars, C, 0);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == C) {
                dist[i] = 0;
                pre = i;
                next = findNext(chars, C, i + 1);
            } else {
                if (i - pre < next - i) {
                    dist[i] = i - pre;
                } else {
                    dist[i] = next - i;
                }
            }
        }

        return dist;
    }

    private int findNext(char[] chars, char c, int i) {
        while (i < chars.length) {
            if (chars[i] == c) {
                return i;
            }
            i++;
        }
        return 100000;
    }
}