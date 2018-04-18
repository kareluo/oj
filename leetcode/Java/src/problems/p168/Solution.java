package problems.p168;

class Solution {

    public String convertToTitle(int n) {
        int x = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            x = n % 26;
            n /= 26;
            if (x == 0) {
                sb.insert(0, 'Z');
                n--;
            } else {
                sb.insert(0, (char) ('A' + x - 1));
            }
        }
        return sb.toString();
    }

}