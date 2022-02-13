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
        
        
        
//         for(int i=0;i<m;i++) {
//             for(int j = 0; j<n;j++) {
//                 System.out.println(" i "+i + " j "+j + " value " + matrix[i][j] );
//                 if(matrix[i][j] == 0) {
                    
//                     // set first element of rows to some value
//                     matrix[i][0] = Integer.MAX_VALUE;
//                     matrix[0][j] = Integer.MAX_VALUE;
//                 }
//             }
//         }
        
        
//          for(int i=0;i<m;i++) {
//             for(int j = 0; j<n;j++) { 
//                 System.out.println(" i "+i + " j "+j + " value " + matrix[i][j] );
//                 if(matrix[i][j] == Integer.MAX_VALUE) {
                    
//                     if(i == 0 && j!=0) {
//                         // set col to zero
//                         for(int k=0;k<m;k++) {
//                             matrix[k][j]=0;
//                         }
//                     }
                    
//                     else if( i!= 0 && j == 0 ) {
//                         for(int k=0;k<n;k++) {
//                             matrix[i][k]=0;
//                         }
//                     }
//                     else if(i == 0 && j == 0) {
//                         for(int k=0;k<m;k++) {
//                             matrix[k][j]=0;
//                         }
//                         for(int k=0;k<n;k++) {
//                             matrix[i][k]=0;
//                         }
//                     }
                    
//                 }
                
//             }
//         }
        
        
        
        
        
    }
}

