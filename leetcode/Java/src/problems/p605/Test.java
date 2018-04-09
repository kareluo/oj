package problems.p605;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canPlaceFlowers(new int[]{1,1,1,1,1,1,1}, 0));
        System.out.println(solution.canPlaceFlowers(new int[]{0,0,0,0,0}, 4));
        System.out.println(solution.canPlaceFlowers(new int[]{1,0,1,0,1}, 1));
        System.out.println(solution.canPlaceFlowers(new int[]{0,0,0,1,0,0,0}, 2));
    }
}
