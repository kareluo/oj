package problems.p781;

class Solution {
    public int numRabbits(int[] answers) {
        int[] colors = new int[1000];

        for (int answer : answers) {
            colors[answer]++;
        }

        int rabbits = 0;
        for (int i = 0; i < 1000; i++) {
            if (colors[i] > 0) {
                rabbits += colors[i];
                if (colors[i] % (i + 1) > 0) {
                    rabbits += (i + 1) - colors[i] % (i + 1);
                }
            }
        }

        return rabbits;
    }
}