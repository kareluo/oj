public class Main {

    public static void main(String[] args) {

        int n = 10;
        int maps[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                maps[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] results = new int[n];

        Dijkstra(maps, results, 0);

        /**
         * 0 ∞ 1 ∞ 3 ∞ 9 ∞
         * ∞ 0 ∞ 2 2 3 ∞ ∞
         * 1 ∞ 0 ∞ ∞ ∞ ∞ ∞
         * ∞ 2 ∞ 0 ∞ ∞ ∞ ∞
         * 3 2 ∞ ∞ 0 ∞ ∞ ∞
         * ∞ 3 ∞ ∞ ∞ 0 ∞ ∞
         * 9 ∞ ∞ ∞ ∞ ∞ 0 ∞
         * ∞ ∞ ∞ ∞ ∞ ∞ ∞ 0
         */
        maps[0][1] = 1;
        maps[0][2] = 2;
        maps[0][3] = 3;

    }

    static void Dijkstra(int[][] maps, int[] results, int root) {
        int n = results.length;
        boolean[] visit = new boolean[n];
        results[root] = 0;
        visit[root] = true;
        System.arraycopy(maps[root], 0, results, 0, n);
        int j, k;
        for (int i = 0; i < n; i++) {
            k = -1;
            for (j = 0; j < n; j++) {
                if (!visit[j] && (k < 0 || results[j] < results[k])) {
                    k = j;
                }
            }
            if (k < 0) break;
            visit[k] = true;
            for (j = 0; j < n; j++) {
                if (!visit[j] && results[j] - results[k] > maps[k][j]) {
                    results[j] = results[k] + maps[k][j];
                }
            }
        }
    }
}

