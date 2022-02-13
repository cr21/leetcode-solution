/*
Time complexity:O(m*n)
space complexity:O(N)
*/
class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        HashSet<Integer> rowset = new HashSet();
        
        HashSet<Integer> colset = new HashSet();
        
        for(int i=0;i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(matrix[i][j] == 0) {
                    
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            if(rowset.contains(i)){
                for(int j=0;j<n;j++) {
                    matrix[i][j]=0;
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            if(colset.contains(i)){
                for(int j=0;j<m;j++) {
                    matrix[j][i]=0;
                }
            }
        }
        
        

        
        
    }
}




// Constant space solution

class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        
        
        
        boolean isCol = false;
        
        for(int i=0;i<m;i++) {
            
            // check for the first row first cell
            // Since first cell for both first row and first column is the same i.e.        matrix[0][0]
      // We can use an additional variable for either the first row/column.
      // For this solution we are using an additional variable for the first column
      // and using matrix[0][0] for the first row.
            if(matrix[i][0] == 0) {
                isCol=true;
            }
            
            for(int j = 1; j<n;j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if(matrix[i][j] == 0) {
                    
                    // set first element of rows to some value
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
         // Iterate over the array once again and using the first row and first column, update the elements.
        for(int i = 1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] =0;
                }
            }
        }
        
         // See if the first row needs to be set to zero as well
   
        if(matrix[0][0] == 0) {
            for(int j=0;j<n;j++) {
                matrix[0][j] = 0;
            }  
        }
        
        // See if the first column needs to be set to zero as well
        if(isCol == true){
            for(int j=0;j<m;j++) {
                matrix[j][0] = 0;
            }
            
        }
            
        
        
        
         
        
        
        
        
    }
}

