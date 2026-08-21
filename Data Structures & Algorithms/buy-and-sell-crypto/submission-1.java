class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min = prices[0];
        for(int current:prices){
            if(min > current){
                min = current;
            }
            profit = Math.max(profit, current - min);
        }
        return profit;
    }
}
