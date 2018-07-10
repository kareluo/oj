package problems.p383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[256];
        char[] chs = magazine.toCharArray();
        for (char ch : chs) chars[ch]++;
        chs = ransomNote.toCharArray();
        for (char ch : chs) chars[ch]--;
        for (int i = 'a'; i <= 'z'; i++)
            if (chars[i] < 0)
                return false;

        return true;
    }
}