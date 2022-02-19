/*

You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

 

Example 1:


Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
Output: 4
Explanation: 
In the beginning, you start at square 1 (at row 5, column 0).
You decide to move to square 2 and must take the ladder to square 15.
You then decide to move to square 17 and must take the snake to square 13.
You then decide to move to square 14 and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
This is the lowest possible number of moves to reach the last square, so return 4.
Example 2:

Input: board = [[-1,-1],[-1,3]]
Output: 1
 

Constraints:

n == board.length == board[i].length
2 <= n <= 20
grid[i][j] is either -1 or in the range [1, n2].
The squares labeled 1 and n2 do not have any ladders or snakes.
*/


class Solution {
    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0) return -1;
        int m = board.length;
        int n = board[0].length;
        
        int [] map = new int[m*n];
        int counter=0;
        int i=m-1;
        int j=0;
        // to alternate movement of columns
        int even = 0;
        
           

        // creat board
        // map will hold the value of where to go from current location
        

        while( i >= 0 && j >= 0) {
            if(board[i][j] == -1) {
                map[counter]=counter;
            }else{
                // next location
                map[counter]=board[i][j]-1;
            }
            
            counter++;
            // if we are iterative even row starting from bottom 
            // increment j 
            if(even%2 == 0 ) {
                j++;
            }else{
                // else decrement the j pointer
                j--;
            }
            
            // when j becomes less than zero we need to go above row and move in correcti direction from left to right 
            if(j<0){
                even--;
                i--;
                j++;
            }else if (j >=n){
                // move from right to left so decrement j 
                even++;
                i--;
                j--;
            }    
        }
        
        
        int levels = 0;        
        Queue<Integer> q = new LinkedList();
        // add location 0 from where we start the game

        q.add(0);
        // mark visited 
        map[0] = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int expanded_node = q.poll();
                if(expanded_node == m*n - 1){   
                    return levels;
                }      
                for(int pos=1;pos<=6;pos++) {
                    int next_move = expanded_node+pos;
                    // if it is not visited or it is valid move
                    if( next_move < (m*n) && map[next_move] != Integer.MAX_VALUE ){
                        // if(map[next_move] > -1){
                        //     // encoutered snake or ladder
                        //     q.add(map[next_move]);
                        // }else{
                        //     q.add(next_move);
                        // }
                        q.add(map[next_move]);
                        // mark visited
                        map[next_move] = Integer.MAX_VALUE;
                    }   
                }   
            }
            levels++;       
        }
        return -1;
        
    }
}
