package problems.p825;

import java.util.Arrays;

class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages.length < 2) return 0;
        Arrays.sort(ages);
        int k = 0, requests = 0;
        for (int i = 0, j = -1; i < ages.length; j = i++) {
            int age = ages[i];
            while (i < ages.length && ages[i] == age) i++;
            i--;
            int small = age / 2 + 7;
            if (small < age) {
                while (k < i && ages[k] <= small) k++;
                if (k < i) requests += (i - k) * (i - j);
            } else k = i;
        }
        return requests;
    }
}