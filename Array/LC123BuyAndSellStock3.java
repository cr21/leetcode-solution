/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 105
*/

class Solution {
    public int maxProfit2(int[] prices) {
        // find out what you will get if you are doing only one transaction
        // try to add first transaction into buying point for 2nd transaction, so finally
        // 2nd transaction profit will combine overall profit of 2 transaction
        if(prices == null  || prices.length == 0) return 0;
        
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        
        int profit1 = 0;
        int profit2 = 0;
        
        for(int price: prices) {
            
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            
            buy2 = Math.min(price - profit1, buy2);
            profit2 = Math.max(profit2, price-buy2);
        }
        
        return profit2;
    }
    
    /*
    
    First, we denote a sequence of prices as Prices[i], with index starting from 0 to N-1. Then we define two arrays, namely left_profits[i] and right_profits[i].

As suggested by the name, each element in the left_profits[i] array would hold the maximum profits that one can gain from doing one single transaction on the left subsequence of prices from the index zero to i, (i.e. Prices[0], Prices[1], ... Prices[i]). For instance, for the subsequences of [7, 1, 5], the corresponding left_profits[2] would be 4, which is to buy the price of 1 and sell it at the price of 5.

And each element in the right_profits[i] array would hold the maximum profits that one can gain from doing one single transaction on the right subsequence of the prices from the index i up to N-1, (i.e. Prices[i], Prices[i+1], ... Prices[N-1]). For example, for the right subsequence of [3, 6, 4], the corresponding right_profits[3] would be 3, which is to buy at the price of 3 and then sell it at the price of 6.

Now, if we divide the sequence of prices around the element at the index i, into two subsequences, with left subsequences as Prices[0], Prices[1], ... Prices[i] and the right subsequence as Prices[i+1], ... Prices[N-1], then the total maximum profits that we obtain from this division (denoted as max_profits[i]) can be expressed as follows: \text{max\_profits[i]} = \text{left\_profits[i]} + \text{right\_profits[i+1]}max_profits[i]=left_profits[i]+right_profits[i+1]
    */
    public int maxProfit(int prices[]) {
        
        if(prices == null || prices.length <=1) return 0;
        
        
        int leftMin = prices[0];
        int rightMax = prices[prices.length-1];
        
        int [] leftProfits = new int[prices.length];
        
        int [] rightProfits = new int[prices.length+1];
        
        for(int i=1;i< prices.length;i++) {
            leftMin = Math.min(leftMin, prices[i]);
            leftProfits[i] = Math.max(leftProfits[i-1], prices[i]-leftMin);
            
        }
        
        for(int i = prices.length-1; i>=0;i-- ) {
            
            rightMax = Math.max(rightMax, prices[i]);
            rightProfits[i] = Math.max(rightProfits[i], rightMax - prices[i]);
        }
        
        
        int maxProfit = 0;
        
        for(int i=0;i<prices.length;i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i]+rightProfits[i+1]);
        }
        return maxProfit;
    }
}
