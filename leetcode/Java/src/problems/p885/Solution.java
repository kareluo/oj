package problems.p885;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] limits = new int[limit + 1];
        for (int weight : people) {
            if (weight <= limit) {
                limits[weight]++;
            }
        }

        int boats = 0;
        int i = 0, j = limit;
        while (i < j) {
            while (i <= limit && limits[i] == 0) i++;
            while (j >= 0 && limits[j] == 0) j--;
            if (i < j) {
                if (i + j > limit) {
                    boats += limits[j];
                    j--;
                } else {
                    boats += Math.min(limits[i], limits[j]);
                    if (limits[j] > limits[i]) {
                        limits[j] -= limits[i];
                        i++;
                    } else if (limits[i] > limits[j]) {
                        limits[i] -= limits[j];
                        j--;
                    } else {
                        i++;
                        j--;
                    }
                }
            }
        }

        if (i == j && limits[i] > 0) {
            if (i << 1 > limit) {
                boats += limits[i];
            } else {
                boats += (limits[i] + 1) >> 1;
            }
        }

        return boats;
    }
}