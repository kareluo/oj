package problems.p121;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (profit < price - minPrice) {
                profit = price - minPrice;
            }
        }

        return profit;
    }
}