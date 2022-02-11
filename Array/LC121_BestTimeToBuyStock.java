class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices == null || prices.length == 0) return 0;
        int ans = 0;
        
        int curMax = prices[prices.length-1];
        
        int curProfit = 0;
        
        // we get zero profit at last price because we could not have a chance to sell stock which 
        // was bought on last day 
        // we will iterate reversly and maintain the hightst amount on right side from current element, by doing this we will get highest profit we could get buying at current location - highest amount we could sell from right side and net effect would be profit
        for(int j = prices.length-2; j>=0;j--) {
            
            curProfit =curMax  - prices[j];
            ans = Math.max(ans, curProfit);
            curMax = Math.max(curMax, prices[j]);
            
            
        }
        
        return  ans;
    }
}

