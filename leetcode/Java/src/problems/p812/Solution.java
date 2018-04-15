package problems.p812;

/**
 * A = 1/2 * [x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)]
 */
class Solution {

    public double largestTriangleArea(int[][] points) {
        double A = 0;
        int i, j, k, x1, x2, y1, y2, y1y2, area;
        for (i = 0; i < points.length; i++) {
            x1 = points[i][0];
            y1 = points[i][1];
            for (j = 0; j < points.length; j++) {
                x2 = points[j][0];
                y2 = points[j][1];
                y1y2 = y1 - y2;
                for (k = 0; k < points.length; k++) {
                    area = x1 * (y2 - points[k][1]) + x2 * (points[k][1] - y1) + points[k][0] * y1y2;
                    if (area > A) {
                        A = area;
                    }
                }
            }
        }
        return A / 2;
    }
}