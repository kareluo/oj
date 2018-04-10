package problems.p290;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.isEmpty() || str.isEmpty()) {
            return false;
        }
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        String[] vs = new String[26];
        for (int i = 0; i < pattern.length(); i++) {
            int pos = pattern.charAt(i) - 'a';
            if (vs[pos] == null) {
                vs[pos] = words[i];
            } else if (!vs[pos].equals(words[i])) {
                return false;
            }
        }

        Set<String> set = new HashSet<>(26);
        for (int i = 0; i < 26; i++) {
            if (vs[i] != null) {
                if (!set.contains(vs[i])) {
                    set.add(vs[i]);
                } else return false;
            }
        }
        return true;
    }
}