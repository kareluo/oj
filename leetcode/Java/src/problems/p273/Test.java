package problems.p273;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();


        //        System.out.println(solution.numberToWords(12345));
//        System.out.println(solution.numberToWords(1234567));
        for (int i = 0; i < 10000; i++) {
            System.out.println(solution.numberToWords(i));
        }

        long millis = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            solution.numberToWords(2147483647);
        }
        System.out.println(System.currentTimeMillis() - millis);

    }
}
