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
    public int maxProfit(int[] prices) {
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
}
