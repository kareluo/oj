package problems.p406;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });

        int[] temp;
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] < i) {
                temp = people[i];
                System.arraycopy(people, temp[1], people, temp[1] + 1, i - temp[1]);
                people[temp[1]] = temp;
            }
        }
        return people;
    }
}