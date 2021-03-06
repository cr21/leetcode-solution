/*
    Given a 2d grid map of '1's (land) and '0's (water), 
    count the number of islands. An island is surrounded by water
     and is formed by connecting adjacent lands horizontally or vertically. 
     You may assume all four edges of the grid are all surrounded by water.

    Example 1:

        Input:
            11110
            11010
            11000
            00000

        Output:
             1
    Example 2:

    Input:
        11000
        11000
        00100
        00011

    Output:
         3

    Space complexity : O(M*N)
    Time complexity :O(M*N)
    is worked on leetcode :  YeS

    BFS :

    starting from each cell run BFS if it is 1 and keep on running till you didnt find
    1 and then goes to different cell then increment the count of island
    and then run BFS for each of the cell

    
*/


import java.util.Queue;
import java.util.LinkedList;

public class No_Of_Island {
    public int numIslands(char[][] grid) {
        if (grid == null ||  grid.length == 0) return  0;
        
        int count = 0;
        Queue<int[]> q =  new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i <  m; i++){
            for (int j = 0; j<n; j++){

                if(grid[i][j] == '1'){
                    count++;
                    q.add(new int[]{i,j});
                    
                    while(!q.isEmpty()){
                        int[]curr = q.poll();
                        for(int[] dir :  dirs){
                            
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            
                            if( r >=0  && r < m && c >=0 && c < n && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                        
                    }
                }
            }
        }
        return count; 
    }

    /*
    DFS Solution

    int m;
    int n;
    int [][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 ) return 0;
        m = grid.length;
        n =  grid[0].length;
        int count=0;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if( grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);       
                }
            }   
        }
        return count;
    }
    
    private void dfs(char[][] grid, int r, int c){
//         base
        
        if( r < 0 || c < 0 || r >=  m || c >= n || grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        for( int[] dir : dirs){
            dfs(grid, dir[0] + r, dir[1]+c);
        }
        
    }
    */
}


/*
DFS Solution : 
class Solution {
    int level;
    int m;
    int n;
    int dirs[][];
    public int numIslands(char[][] grid) {
        level = 0;
        dirs  = new int [][] {{0,1},{0,-1},{1,0},{-1,0}};
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        for(int i =0; i< grid.length;i++) {
            for (int j=0; j< grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i, j);   
                    level++;
                }
                
            }
        }
        
        return level;
    }
    
    private void dfs(char[][]grid, int i , int j) {
             if( grid[i][j] == '0') {
                    // level++;
                    return;
                }
                if(grid[i][j] == '1') {
                    grid[i][j] = '2';
            }
        

        
        for(int [] dir : dirs) {
            int r = dir[0] + i;
            int c  = dir[1] + j;
            if(r>=0 && r< m && c >=0  && c < n && grid[r][c] != '2') {
                dfs(grid, r,c);    
            } 
            
        }
    }
}

*/
