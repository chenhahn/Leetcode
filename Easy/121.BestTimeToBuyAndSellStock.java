class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            if(prices[i] - min > result) result = prices[i] - min;
        }
        return result;
    }
}