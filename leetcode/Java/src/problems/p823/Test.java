package problems.p823;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.numFactoredBinaryTrees(new int[]{2, 4}));
//        System.out.println(solution.numFactoredBinaryTrees(new int[]{2, 4, 8, 16}));

        for(int i=2; i<1000000000; i <<=1) {
            System.out.print(i+", ");
        }
    }
}
