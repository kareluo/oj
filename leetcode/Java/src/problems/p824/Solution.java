package problems.p824;

class Solution {
    public String toGoatLatin(String S) {
        if (S.isEmpty()) return S;
        StringBuilder sb = new StringBuilder();
        StringBuilder a = new StringBuilder("a");
        String[] words = S.split(" +");
        for (String word : words) {
            sb.append(" ");
            char ch = word.charAt(0);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sb.append(word).append("ma").append(a);
            } else {
                sb.append(word.substring(1)).append(ch).append("ma").append(a);
            }
            a.append('a');
        }

        return sb.deleteCharAt(0).toString();
    }
}