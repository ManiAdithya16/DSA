class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int mincost = prices[0];
        for(int i=1;i<prices.length;i++){
            mincost = Math.min(prices[i], mincost);
            int profit = prices[i] - mincost;
            maxprofit = Math.max(maxprofit, profit);
            }
        return maxprofit;
    }
}