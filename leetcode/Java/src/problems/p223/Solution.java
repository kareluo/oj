package problems.p223;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = Math.max(A, E), b = Math.max(B, F);
        int c = Math.min(C, G), d = Math.min(D, H);
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (a < c && b < d) {
            area -= (c - a) * (d - b);
        }
        return area;
    }
}