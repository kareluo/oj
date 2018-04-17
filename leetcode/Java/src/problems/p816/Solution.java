package problems.p816;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<String> ambiguousCoordinates(String S) {
        List<String> ss = new LinkedList<>();
        for (int i = 2; i < S.length() - 1; i++) {
            List<String> combine = combine(S.substring(1, i), S.substring(i, S.length() - 1));
            if (combine != null) {
                ss.addAll(combine);
            }
        }
        return ss;
    }

    private List<String> combine(String x, String y) {
        if (x.startsWith("0") && x.endsWith("0")) {
            if (x.length() > 1) {
                return null;
            }
        }

        if (y.startsWith("0") && y.endsWith("0")) {
            if (y.length() > 1) {
                return null;
            }
        }

        List<String> res = new LinkedList<>();

        List<String> xs = new LinkedList<>();
        split(xs, x);

        List<String> ys = new LinkedList<>();
        split(ys, y);

        for (String cx : xs) {
            for (String cy : ys) {
                res.add("(" + cx + ", " + cy + ")");
            }
        }

        return res;
    }

    private void split(List<String> ss, String s) {
        if (s.startsWith("0")) {
            if (s.length() == 1) {
                ss.add("0");
            } else {
                ss.add("0." + s.substring(1, s.length()));
            }
        } else if (s.endsWith("0")) {
            ss.add(s);
        } else {
            ss.add(s);
            for (int i = 1; i < s.length(); i++) {
                ss.add(s.substring(0, i) + "." + s.substring(i, s.length()));
            }
        }
    }
}