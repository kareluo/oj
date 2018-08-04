package problems.p49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> exits = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int[] s = new int[26];
            for (int i = 0; i < str.length(); i++) {
                s[str.charAt(i) - 97]++;
            }
            sb.delete(0, sb.length());
            for (int i = 0; i < 26; i++) {
                sb.append(s[i]).append(",");
            }
            String key = sb.toString();
            List<String> values = exits.get(key);
            if (values == null) {
                values = new ArrayList<>();
                exits.put(key, values);
            }
            values.add(str);
        }
        return new ArrayList<>(exits.values());
    }
}