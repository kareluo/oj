package problems.p4;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{665}, new int[]{358}));
        System.out.println(solution.findMedianSortedArrays(new int[]{873}, new int[]{201, 232, 883}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));


        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            List<Integer> num1 = new ArrayList<>();
            List<Integer> num2 = new ArrayList<>();

            int len1 = random.nextInt(100) + 1;
            for (int j = 0; j < len1; j++) {
                num1.add(random.nextInt(1000));
            }

            int len2 = random.nextInt(100) + 1;
            for (int j = 0; j < len2; j++) {
                num2.add(random.nextInt(1000));
            }

            Collections.sort(num1);
            Collections.sort(num2);

            List<Integer> nums = new ArrayList<>(num1.size() + num2.size());
            nums.addAll(num1);
            nums.addAll(num2);

            Collections.sort(nums);

            double expectedAnswer = 0;
            if (nums.size() % 2 == 1) {
                expectedAnswer = nums.get(nums.size() / 2);
            } else {
                expectedAnswer = (nums.get(nums.size() / 2 - 1) + nums.get(nums.size() / 2)) / 2.0;
            }

            int[] number1 = new int[num1.size()];
            int[] number2 = new int[num2.size()];

            for (int j = 0; j < num1.size(); j++) {
                number1[j] = num1.get(j);
            }

            for (int j = 0; j < num2.size(); j++) {
                number2[j] = num2.get(j);
            }

            double ans = solution.findMedianSortedArrays(number1, number2);
            if (expectedAnswer != ans) {
                System.out.println("Answer: " + ans + ", Expected Answer: " + expectedAnswer);

                for (int num : num1) {
                    System.out.print(num);
                    System.out.print(", ");
                }

                System.out.println();

                for (int num : num2) {
                    System.out.print(num);
                    System.out.print(", ");
                }

                System.out.println();
                System.out.println();
            }
        }
    }
}
