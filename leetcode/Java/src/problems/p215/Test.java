package problems.p215;

import util.PrinterUtils;
import util.RandomUtils;

import java.util.Arrays;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int num = solution.findKthLargest(new int[]{10, 3, 6, 4, 1, 1, 2, 0}, 4);
//        System.out.println(num);

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int[] nums = RandomUtils.random(random, -1231231, 2313223, random.nextInt(100000) + 1);
            int k = random.nextInt(nums.length) + 1;
//            PrinterUtils.println(nums);
            int largest = solution.findKthLargest(nums, k);
//            PrinterUtils.println(nums);
            Arrays.sort(nums);
//            PrinterUtils.println(nums);
            if (largest != nums[nums.length - k]) {
                System.out.println("error:" + k);
                System.out.println();
//                System.out.println(largest);
//                System.out.println(nums[nums.length - k]);
//                System.out.println();
            } else {
//                System.out.println();
//                System.out.println();
            }
        }
    }
}
