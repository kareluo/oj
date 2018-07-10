package problems.p831;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maskPII("LeetCode@LeetCode.com"));
        System.out.println(solution.maskPII("AB@qq.com"));
        System.out.println(solution.maskPII("1(234)567-890"));
        System.out.println(solution.maskPII("86-(10)12345678"));
        System.out.println(solution.maskPII("086-(10)12345678"));
        System.out.println(solution.maskPII("6-(10)12345678"));
        System.out.println(solution.maskPII("6-(10)12345678"));
        System.out.println(solution.maskPII("(10)12345678"));
        System.out.println(solution.maskPII("+(501321)-50-23431"));
        System.out.println(solution.maskPII("+   (  501321)-50-23431"));
    }
}
