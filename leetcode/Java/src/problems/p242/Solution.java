package problems.p242;

class Solution {

    public boolean isAnagram(String s, String t) {
        int[] v = new int[26];
        for (int i = 0; i < s.length(); i++) {
            v[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            v[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (v[i] != 0) return false;
        }

        return true;
    }
}