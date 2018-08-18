package problems.p714;

// TODO
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length < 2) return 0;
        int i = 1, profit = 0, min = prices[0], max;
//        while (i < prices.length) {
//            while (i < prices.length && prices[i] <= min) {
//                min = prices[i++];
//            }
//            if (i >= prices.length) break;
//            max = prices[i++];
//            while (i < prices.length && prices[i] >= max) {
//                max = prices[i++];
//            }
//            if (max > min + 2) {
//
//            }
//            profit += max - min;
//            if (i >= prices.length) break;
//            min = prices[i++];
//        }
        return profit;
    }
}