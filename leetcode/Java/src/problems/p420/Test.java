package problems.p420;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.strongPasswordChecker("aaaabbaaabbaaa123456A"));
        System.out.println(solution.strongPasswordChecker("QQQQQ"));
        System.out.println(solution.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(solution.strongPasswordChecker(""));
        System.out.println(solution.strongPasswordChecker("aaa111"));
        System.out.println(solution.strongPasswordChecker("12345667"));
        System.out.println(solution.strongPasswordChecker("aaaaaaaa"));
        System.out.println(solution.strongPasswordChecker("aaabbbccc"));
        System.out.println(solution.strongPasswordChecker("felix1992"));
        System.out.println(solution.strongPasswordChecker("aabbccddee"));
        System.out.println(solution.strongPasswordChecker("aabbccddeeaabbccddeeaabbccddeeaabbccddeeaabbccddee"));

    }

}
