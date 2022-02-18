/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

class Solution {
    HashSet<Character> colset = new HashSet();
    HashSet<Character> rowset = new HashSet();
    HashSet<Character> boxeset = new HashSet();
    public boolean isValidSudoku(char[][] board) {
           
        int rows = board.length;
        int cols = board[0].length;
        // check for rows
        
        for(int i=0;i< rows;i++) {
            //. checking row i 
            rowset = new HashSet();
            // check for every column
            for(int j=0;j< cols;j++) {
                char ch = board[i][j];
                if(rowset.contains(ch)) {
                    return false;
                }else{
                    if(Character.isDigit(ch)) {
                        rowset.add(ch);
                    }
                }   
            }  
            
        }
        
        // check for columns
        for(int i=0;i<cols;i++){
            colset = new HashSet();
            for(int j=0;j<rows;j++) {
                char ch = board[j][i];
                if(colset.contains(ch)) {
                    return false;
                }else{
                    if(Character.isDigit(ch)) {
                        colset.add(ch);
                    }
                }  
            }
            
        }
        
        
            // check for boxes
            
        for(int row=0;row<3;row++) {
            for(int col =0;col<3;col++) {
                // new box starts here
                boxeset = new HashSet();
                // iterate over the box
                
                for(int i=row*3;i<row*3+3;i++){
                    for(int j=col*3;j<col*3+3;j++){
                        if(boxeset.contains(board[i][j])) {
                            return false;
                        }else{
                            if(Character.isDigit(board[i][j])) {
                                boxeset.add(board[i][j]);
                            }
                        }
                    }
                }
            }
        }
        
        return true;
                

           
    }

}
