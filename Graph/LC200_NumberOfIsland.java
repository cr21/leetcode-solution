/*

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

*/

class Solution {
    int dirs [][];
    int m;
    int n;
    char [][] grid;
    public int numIslands(char[][] grid) {
        
        dirs= new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        this.grid = grid;
        if(grid == null)  return 0;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0;i < m;i++) {
            for(int j=0; j < n ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    grid[i][j]  = '0';
                    dfs(i,j);   
                }   
            }     
        }
        
        
        return count;
    }
    
    
    private void dfs(int row, int col) {
        
        for(int [] dir: dirs) {
            int r = dir[0];
            int c = dir[1];    
            int newR = row + r;
            int newC = col + c;
            if(newR >= 0 && newR < m && newC >=0 && newC < n && grid[newR][newC] == '1') {
                grid[newR][newC] = '0';
                dfs(newR, newC);   
            }   
        }   
    }
}
