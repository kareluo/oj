package problems.p682;

class Solution {
    public int calPoints(String[] ops) {
        int index = 0;
        int[] scores = new int[ops.length];
        for (String op : ops) {
            switch (op) {
                case "C":
                    index--;
                    break;
                case "D":
                    scores[index] = scores[index - 1] * 2;
                    index++;
                    break;
                case "+":
                    scores[index] = scores[index - 1] + scores[index - 2];
                    index++;
                    break;
                default:
                    scores[index++] = Integer.parseInt(op);
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += scores[i];
        }
        return sum;
    }
}