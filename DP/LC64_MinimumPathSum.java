/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
*/

class Solution {
    public int minPathSum(int[][] grid) {
        
        if(grid == null || grid[0].length == 0 ) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int dp [][] = new int [m] [n];
       
        dp[0][0] = grid[0][0];
        for(int i=1;i<m;i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        
        for(int i=1;i<n;i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        
        for(int i=1; i< m;i++) {
            for(int j = 1; j<n;j++) {
            
                // from left to right
                int case1 = dp[i][j-1];
                // from top to bottom
                int case2 = dp[i-1][j];
                
                dp[i][j] = Math.min(case1, case2) + grid[i][j];
            }
        }
        
        return dp[m-1][n-1];
        
    }
}
