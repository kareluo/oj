package problems.p500;

import util.PrinterUtils;

public class Test {

    public static void main(String[] args) {
        String one = "qwertyuiop";
        String two = "asdfghjkl";
        String three = "zxcvbnm";

        int[] pos = new int[127];
        for (int ch = 'a'; ch <= 'z'; ch++) {
            if (one.indexOf(ch) >= 0) {
                pos[ch] = 1;
            } else if (two.indexOf(ch) >= 0) {
                pos[ch] = 2;
            } else if (three.indexOf(ch) >= 0) {
                pos[ch] = 3;
            }
        }

        one = one.toUpperCase();
        two = two.toUpperCase();
        three = three.toUpperCase();
        for (int ch = 'A'; ch <= 'Z'; ch++) {
            if (one.indexOf(ch) >= 0) {
                pos[ch] = 1;
            } else if (two.indexOf(ch) >= 0) {
                pos[ch] = 2;
            } else if (three.indexOf(ch) >= 0) {
                pos[ch] = 3;
            }
        }


        PrinterUtils.println(pos);
    }
}
