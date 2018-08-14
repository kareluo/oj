package problems.p278;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int begin = 1, end = n;
        while (begin <= end) {
            int v = begin + ((end - begin) >> 1);
            if (isBadVersion(v)) {
                if (v == 1) {
                    return v;
                }
                if (!isBadVersion(v - 1)) {
                    return v;
                }
                end = v - 1;
            } else begin = v + 1;
        }
        return n;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}