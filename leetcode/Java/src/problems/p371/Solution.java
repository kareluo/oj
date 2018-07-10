package problems.p371;

class Solution {
    public int getSum(int a, int b) {
        int c = 0;
        for (int i = 0, j = 0; i < 32; i++) {
            int aa = (a >> i) & 1;
            int bb = (b >> i) & 1;
            c |= (j ^ aa ^ bb) << i;
            j = aa & bb | (j & (aa ^ bb));
        }
        return c;
    }
}