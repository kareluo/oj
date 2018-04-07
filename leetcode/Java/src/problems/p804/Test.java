package problems.p804;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"", "", "msg"}));
        System.out.println(solution.uniqueMorseRepresentations(new String[]{"gin", "gin", "gin", "gin"}));

        long millis = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        }
        System.out.println(System.currentTimeMillis() - millis);
    }
}
