package problems.p87;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isScramble("abcdeds", "dbcedsa"));
        System.out.println(solution.isScramble("abcdedsa", "dbcedsaa"));
        System.out.println(solution.isScramble("ccabcbabcbabbbbcbb", "bbbbabccccbbbabcba"));
        System.out.println(solution.isScramble("oatzzffqpnwcxhejzjsnpmkmzngneo", "acegneonzmkmpnsjzjhxwnpqffzzto"));
    }
}
