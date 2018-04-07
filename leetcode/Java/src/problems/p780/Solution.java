package problems.p780;

class Solution {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx || ty > sy) {
            if (tx > ty) {
                tx -= ty * Math.max((tx - sx) / ty, 1);
            } else {
                ty -= tx * Math.max((ty - sy) / tx, 1);
            }
            if (tx <= 0 || ty <= 0) break;
        }
        return tx == sx && ty == sy;
    }
}
