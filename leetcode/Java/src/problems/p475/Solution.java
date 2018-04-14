package problems.p475;

import java.util.Arrays;

class Solution {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0, smaller;
        for (int i = 0, j = 0, pj = -1; i < houses.length; i++) {
            while (j < heaters.length && heaters[j] < houses[i]) {
                pj = j;
                j++;
            }

            if (j < heaters.length) {
                smaller = heaters[j] - houses[i];
            } else {
                smaller = Integer.MAX_VALUE;
            }

            if (pj >= 0 && smaller > houses[i] - heaters[pj]) {
                smaller = houses[i] - heaters[pj];
            }

            if (smaller > radius) {
                radius = smaller;
            }
        }

        return radius;
    }
}