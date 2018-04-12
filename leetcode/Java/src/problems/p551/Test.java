package problems.p551;

import util.TimeUtils;

public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));
        System.out.println(solution.checkRecord("PPPPPPP"));
        System.out.println(solution.checkRecord("A"));
        System.out.println(solution.checkRecord("AL"));
        System.out.println(solution.checkRecord("ALL"));
        System.out.println(solution.checkRecord("AA"));
        System.out.println(solution.checkRecord("AAAAA"));
        System.out.println(solution.checkRecord("LL"));
    }
}

/*
"PPALLP"
"PPALLL"
"PPPPPPP"
"A"
"AL"
"ALL"
"AA"
"AAAAA"
"LL"
"ALL"
"LALL"
"ALLL"
""
 */
