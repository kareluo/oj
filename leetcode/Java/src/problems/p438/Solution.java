package problems.p438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> anagrams = new ArrayList<>();

        if (s.length() < p.length()) {
            return anagrams;
        }

        int[] peCounts = new int[26];
        int[] abCounts = new int[26];
        int[] aeCounts = new int[26];

        char[] as = s.toCharArray();
        char[] ps = p.toCharArray();

        for (int i = 0; i < ps.length; i++) {
            peCounts[ps[i] - 'a']++;
            aeCounts[as[i] - 'a']++;
        }

        for (int i = ps.length; i <= as.length; i++) {
            boolean equals = true;
            for (int j = 0; j < 26; j++) {
                if (aeCounts[j] - abCounts[j] != peCounts[j]) {
                    equals = false;
                    break;
                }
            }

            if (equals) anagrams.add(i - ps.length);

            if (i < as.length) {
                aeCounts[as[i] - 'a']++;
                abCounts[as[i - ps.length] - 'a']++;
            }
        }

        return anagrams;
    }
}