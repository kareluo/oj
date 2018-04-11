package util;

public class Utils {

    public static boolean equals(int[] as, int[] bs) {
        if (as == bs) return true;
        if (as == null || bs == null || as.length != bs.length) {
            return false;
        }
        for (int i = 0; i < as.length; i++) {
            if (as[i] != bs[i]) {
                return false;
            }
        }
        return true;
    }
}
