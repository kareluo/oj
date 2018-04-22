package problems.p647;

class Solution {
    public int countSubstrings(String s) {
        boolean flag;
        int palindromes = 0;
        char[] chars = s.toCharArray();
        boolean[] palindrome = new boolean[chars.length];
        for (int i = 0, index = 1; i < chars.length; i++) {
            palindromes++;
            palindrome[i] = true;
            flag = false;
            for (int j = index - 1; j < i; j++) {
                if (chars[j] == chars[i] && palindrome[j + 1]) {
                    palindrome[j] = true;
                    palindromes++;
                    if (!flag) {
                        index = j;
                        flag = true;
                    }
                } else palindrome[j] = false;
            }

            if (!flag) {
                index = i;
            }

            if (index < 1) {
                index = 1;
            }
        }
        return palindromes;
    }
}