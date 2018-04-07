package problems.p805;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution.splitArraySameAverage(new int[]{1, 1, 2}));
        System.out.println(solution.splitArraySameAverage(new int[]{0, 0, 0, 0}));
        System.out.println(solution.splitArraySameAverage(new int[]{0}));
        System.out.println(solution.splitArraySameAverage(new int[]{3, 1}));
        System.out.println(solution.splitArraySameAverage(new int[]{18, 10, 5, 3}));

        long millis = System.currentTimeMillis();
        System.out.println(solution.splitArraySameAverage(new int[]{3322, 959, 598, 506, 4442, 3594, 8382, 7777, 7002, 7078, 2278, 4902, 1276, 1}));

        System.out.println(System.currentTimeMillis() - millis);

//        Random random = new Random();
//        int[] values = new int[30];
//        for (int i = 0; i < values.length; i++) {
//            values[i] = random.nextInt(10000);
//        }
//
//        System.out.println(solution.splitArraySameAverage(values));

    }
}
