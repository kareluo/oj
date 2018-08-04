package util;

import java.util.Collection;

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

    public static void print(int[] es) {
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
        System.out.print("]");
    }

    public static <E> void println(Collection<E> es) {
        System.out.print("[");
        for (E e : es) {
            System.out.print(e + ", ");
        }
        System.out.println("]");
    }

    public static void println(int[][] es) {
        if (es == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        if (es.length > 0) {
            print(es[0]);
        }
        for (int i = 1; i < es.length; i++) {
            System.out.print(",");
            print(es[i]);
        }
        System.out.println("]");
    }

    public static void print(char[] es) {
        if (es == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        if (es.length > 0) {
            System.out.print("\"" + es[0] + "\"");
        }
        for (int i = 1; i < es.length; i++) {
            System.out.print(", \"" + es[i] + "\"");
        }
        System.out.print("]");
    }

    public static void println(char[][] es) {
        if (es == null) {
            System.out.println("null");
            return;
        }

        System.out.print("[");
        if (es.length > 0) {
            print(es[0]);
        }
        for (int i = 1; i < es.length; i++) {
            System.out.print(",");
            print(es[i]);
        }
        System.out.println("]");
    }
}
