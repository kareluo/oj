package problems.p763;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        boolean[] appear = new boolean[128];
        int[] begins = new int[128];
        int[] ends = new int[128];
        char[] chs = new char[26];
        char[] chars = S.toCharArray();
        char ch;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            ch = chars[i];
            if (!appear[ch]) {
                begins[ch] = i;
                appear[ch] = true;
                chs[index++] = ch;
            }
            ends[ch] = i;
        }

        List<Integer> ans = new LinkedList<>();
        int begin = 0, end = ends[chs[0]];
        for (int i = 0; i < index; i++) {
            if (begins[chs[i]] > end) {
                ans.add(end - begin + 1);
                begin = begins[chs[i]];
                end = ends[chs[i]];
            } else {
                end = Math.max(end, ends[chs[i]]);
            }
        }
        ans.add(end - begin + 1);
        return ans;
    }
}