package util;

public class TimeUtils {

    private static long sMillis;

    public static void begin() {
        sMillis = System.currentTimeMillis();
    }

    public static long end() {
        sMillis = System.currentTimeMillis() - sMillis;
        System.out.println(sMillis + "sm");
        return sMillis;
    }

}
