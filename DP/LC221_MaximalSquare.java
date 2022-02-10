class Solution {
    int maxLength = 0;
    
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int length = 0;
        boolean flag = false;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i < n;i++) {
            // first row 
            if(matrix[0][i] == '1') {
                dp[0][i] = 1;
            }   
        }
        
        // process first column
        for(int i=0;i< m;i++) {
            for(int j = 0;j<n;j++) {
                char cur = matrix[i][j];
                if(cur == '1') {
                    flag = true;
                    // Minimum length square starting from i and j will be 1
                    length =1;
                    // // rows and diagnoal and columns

                    while( i+ length < m && j+length < n && flag) {

                        // row checking
                        for(int k=i;k<= i+length;k++) {
                            if(matrix[k][j+length] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        // col checking
                        for(int k=j;k<= j+length;k++) {
                            if(matrix[i+length][k] == '0') {
                                flag = false;
                                break;
                            }
                        }

                        if(flag){
                            length++;
                        }

                    }
                    maxLength = Math.max(maxLength, length);
                }
            }   
        }
        return maxLength * maxLength;
    }
}

