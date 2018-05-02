package problems.p441;

class Solution {
    public int arrangeCoins(int n) {
        return (int) Math.floor(Math.sqrt(2.0 * n + .25) - .5);
    }
}