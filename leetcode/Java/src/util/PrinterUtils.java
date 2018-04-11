package util;

public class PrinterUtils {

    public static <E> void println(E[] es) {
        if (es == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        if (es.length > 0) {
            System.out.print(es[0]);
        }
        for (int i = 1; i < es.length; i++) {
            System.out.print(", " + es[i]);
        }
        System.out.println("]");
    }

    public static void println(int[] es) {
        if (es == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        if (es.length > 0) {
            System.out.print(es[0]);
        }
        for (int i = 1; i < es.length; i++) {
            System.out.print(", " + es[i]);
        }
        System.out.println("]");
    }
}
