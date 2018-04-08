package problems.p38;

class Solution {

    public String countAndSay(int n) {
        return say("1", n);
    }

    private String say(String term, int count) {
        if (count <= 1) {
            return term;
        }
        int n = 1;
        char ch = term.charAt(0);
        StringBuilder sb = new StringBuilder(term.length() << 1);
        for (int i = 1; i < term.length(); i++) {
            if (ch == term.charAt(i)) {
                n++;
            } else {
                sb.append(n).append(ch);
                ch = term.charAt(i);
                n = 1;
            }
        }
        sb.append(n).append(ch);
        return say(sb.toString(), count - 1);
    }
}
