package problems.p805;

/**
 * by Felix 2018/4/1 15:55
 * <p>
 * 分为B和C数组，假设长度分别为lenB和lenC，并且假设B为较短的那个，
 * 那么lenB的最大值为lenA/2，avg为平均值（可能为不为整数）。那么B
 * 的最大容量为avg*lenB设为vesselB，v[][]表示v[容量][数量]是否有
 * 可行解，即v[x][y]为true表示y个数字组成和为x是否有解。
 *
 * 转移方程式如下：
 * v[i][j] = v[i-a][j-1]
 * 其中a表示当前A数组中的一个值。
 *
 * 最后枚举下lenB判断有无解即可。
 */
class Solution {

    public boolean splitArraySameAverage(int[] A) {
        int total = 0, len = A.length >> 1;
        for (int a : A) total += a;

        int mv = (int) Math.round(Math.ceil(1f * len * total / A.length));

        boolean[][] v = new boolean[mv + 1][Math.max(len + 1, 2)];
        int index = 0;
        for (int a : A) {
            if (a > mv) continue;
            for (int i = mv; i >= a; i--) {
                if (v[i - a][0]) {
                    for (int j = 1; j < index; j++) {
                        if (v[i - a][j]) {
                            v[i][j + 1] = true;
                        }
                    }
                    v[i][0] = true;
                }
            }
            v[a][1] = v[a][0] = true;
            index = Math.min(index + 1, len);
        }

        int vessel;
        for (int i = 1; i <= len; i++) {
            vessel = i * total;
            if (vessel % A.length == 0 && vessel / A.length <= mv) {
                if (v[vessel / A.length][i]) {
                    return true;
                }
            }
        }

        return false;
    }
}