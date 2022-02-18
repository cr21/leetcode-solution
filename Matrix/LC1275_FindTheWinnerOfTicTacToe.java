/*

Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

Players take turns placing characters into empty squares ' '.
The first player A always places 'X' characters, while the second player B always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never on filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

 

Example 1:


Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.
*/

class Solution {
    
    private boolean checkWinner(char[][] grid, int row, int col, boolean isPlayerA) {
        char toCheck = isPlayerA ? 'X':'O';
       
        
        // check entire row
        // check entire row
        if(grid[row][0] == toCheck &&  grid[row][1] == toCheck && grid[row][2] == toCheck) {
            return true;
        }
        
        // check column
        
        if(grid[0][col] == toCheck && grid[1][col] == toCheck && grid[2][col] == toCheck) {
            return true;
        }
        
        // check diagonal only for row and col equals
        
        // left top to right bottom
        if(grid[0][0] ==toCheck && grid[1][1] ==toCheck && grid[2][2] == toCheck ) {
            return true;
        }


        if(grid[0][2] ==toCheck && grid[1][1] ==toCheck && grid[2][0] == toCheck ) {
            return true;
        }
        
        
        return false;
        
        
    }
    public String tictactoe(int[][] moves) {
        
        int totalfilled = 0;
        char grid[][] = new char[3][3];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                grid[i][j] = '.';
            }
        }
        boolean isPlayerA = true;
        
        for(int i=0;i<moves.length;i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            if(grid[r][c] == '.') {
                if(isPlayerA){
                    grid[r][c] = 'X';
                    if(checkWinner(grid, r, c, isPlayerA)){
                        return "A";   
                    }
                }else{
                    grid[r][c] = 'O'; 
                    if(checkWinner(grid, r, c,isPlayerA)){
                        return "B";   
                    }
                }  
            }
            
            
            isPlayerA=!isPlayerA;
            
            
            
        }
        
        return moves.length < 9 ?"Pending" : "Draw";
        
        
        
    }
}
