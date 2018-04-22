package problems.p822;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        if (fronts.length != backs.length) {
            return 0;
        }

        boolean[] v = new boolean[2001];
        boolean[] u = new boolean[2001];
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] != backs[i]) {
                if (!v[fronts[i]]) u[fronts[i]] = true;
                if (!v[backs[i]]) u[backs[i]] = true;
            } else {
                v[fronts[i]] = true;
                u[fronts[i]] = false;
            }
        }

        for (int i = 1; i <= 2000; i++) {
            if (u[i]) return i;
        }

        return 0;
    }
}