package problems.P204;

public class SolutionBest {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 1;
        boolean[] v = new boolean[n];
        for (int i = 3; i * i <= n; i += 2) {
            if (v[i]) continue;
            for (int j = i; j * i < n; j += 2) {
                v[j * i] = true;
            }
        }
        for (int i = 3; i < n; i += 2) {
            if (!v[i]) count++;
        }
        return count;
    }
}
