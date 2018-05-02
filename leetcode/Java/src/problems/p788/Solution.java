package problems.p788;

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        boolean valid = false, invalid = false;
        boolean[] v = new boolean[]{false, false, true, false, false, true, true, false, false, true};
        boolean[] iv = new boolean[]{false, false, false, true, true, false, false, true, false, false};
        for (int i = 1, j; i <= N; i++) {
            j = i;
            valid = invalid = false;
            while (!invalid && j != 0) {
                valid |= v[j % 10];
                invalid = iv[j % 10];
                j /= 10;
            }
            if (valid && !invalid) count++;
        }
        return count;
    }
}