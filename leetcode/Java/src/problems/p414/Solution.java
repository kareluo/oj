package problems.p414;

class Solution {
    public int thirdMax(int[] nums) {
        boolean equalsC = false;
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE, n = 0;
        for (int num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
                n++;
            } else if (num < a && num > b) {
                c = b;
                b = num;
                n++;
            } else if (num < b && num > c) {
                c = num;
                n++;
            } else if (num == c && !equalsC) {
                n++;
                equalsC = true;
            }
        }
        return n >= 3 ? c : a;
    }
}