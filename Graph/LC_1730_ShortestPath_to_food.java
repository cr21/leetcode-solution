
/*
You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.

You are given an m x n character matrix, grid, of these different types of cells:

'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.


[["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]

Expected output : 3
  */
class Solution {
    int dirs[][];
    public int getFood(char[][] grid) {
        if ( grid == null || grid.length == 0) {
            return 0;
        }
        
        dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int location [] = new int[2];
        
        for(int i =0;i<grid.length;i++) {
            for(int j=0;j< grid[0].length;j++) {
                if(grid[i][j] == '*') {
                    location[0] =i;
                    location[1] = j;
                }   
            }
        }
        
        int count =0;
        
        boolean  found = false;
        Queue<int[] > q = new LinkedList();
        q.add(location);
        int i=0;
        while(!q.isEmpty()) {
            i++;
            int size = q.size();
            // process level by level
            while(size-->0) {
                int [] current = q.poll();
                int x = current[0];
                int y = current[1];
                
                for(int [] dir: dirs){
                    
                    int dx =x + dir[0];
                    int dy = y+dir[1];
                    if(dx>=0  && dx < grid.length && dy >=0 && dy < grid[0].length && grid[dx][dy]!='X') {
                        // if food empty space add it to the queue and mark the location
                        if(grid[dx][dy]=='#'){
                            found=true;
                            return count+1;
                            // break;
                        }
                        else if(grid[dx][dy] == 'O') {
                            grid[dx][dy] = 'X';
                            q.add(new int[]{dx,dy});
                        }
                        
                    }
                }
            }
            
            
            // level finish increament count++;
            count+=1;
            // if(found) {
            //     return count;
            // }
        }
        
        return -1;
        
    }
}
