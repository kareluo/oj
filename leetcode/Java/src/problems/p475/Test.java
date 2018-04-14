package problems.p475;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRadius(new int[]{1, 5}, new int[]{10}));
        System.out.println(solution.findRadius(new int[]{1, 5}, new int[]{}));
        System.out.println(solution.findRadius(new int[]{}, new int[]{}));
        System.out.println(solution.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(solution.findRadius(new int[]{1, 2, 3, 4}, new int[]{6, 1}));
    }
}
