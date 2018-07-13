package problems.p739;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        int[] positions = new int[temperatures.length];
        for (int i = temperatures.length - 1, j; i >= 0; i--) {
            j = i + 1;
            answers[i] = 0;
            positions[i] = temperatures.length;
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    answers[i] = j - i;
                    positions[i] = j;
                    break;
                }
                j = positions[j];
            }
        }
        return answers;
    }
}