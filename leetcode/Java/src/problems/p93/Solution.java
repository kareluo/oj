package problems.p93;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int[] ipAddress = new int[5];

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> ips = new ArrayList<>();
        dfs(ips, s.toCharArray(), 0, 0);
        return ips;
    }

    private void dfs(List<String> ips, char[] chs, int index, int pos) {
        if (index >= chs.length) {
            if (pos > 3) {
                ips.add(ipAddress[0] + "." + ipAddress[1] + "." + ipAddress[2] + "." + ipAddress[3]);
            }
            return;
        }
        if (pos > 3) return;
        ipAddress[pos] = ipAddress[pos] * 10 + chs[index] - '0';
        if (ipAddress[pos] > 255) return;
        if (ipAddress[pos] == 0 || ipAddress[pos] >= 100) {
            ipAddress[pos + 1] = 0;
            dfs(ips, chs, index + 1, pos + 1);
        } else {
            ipAddress[pos + 1] = 0;
            dfs(ips, chs, index + 1, pos + 1);
            dfs(ips, chs, index + 1, pos);
        }
    }
}