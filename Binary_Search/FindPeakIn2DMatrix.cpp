class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        if(mat.empty()) return vector<int> {-1,-1};
            
            
        
        
        int start = 0;
        int end = mat[0].size()-1;
        
        
        while(start <= end) {
            
            int maxRow = 0;
            int midCol = start + (end-start)/2;
            
            // find the maximum index of row in mid Col
            // find max of Col 
            
            for(int r = 0; r < mat.size(); r++) {
               maxRow = mat[r][midCol] >= mat[maxRow][midCol] ? r : maxRow;
            
            }
            
            // after finding the max of mid col check for adjacent the row and column if element is bigger than adjacent 
            // it is our pick
            
            // if peak lies in left part
            bool isInLeft = (midCol - 1 >= start ) && (  mat[maxRow][midCol] < mat[maxRow][midCol-1]);
            // if peak lies in right part of middle 
            bool isInRight = (midCol +1 <= end ) && (mat[maxRow][midCol] < mat[maxRow][midCol+1]);
            if( !isInLeft && !isInRight ) {
                return vector<int> {maxRow, midCol};
            } else if ( isInLeft) {
                // if peak is in left side move end pointer to midCol
              // else move start pointer to midCol+1
                end = midCol - 1;
            }else{
                start = midCol+1; 
            }
            
        }
        
        return vector<int>{-1,-1};
        
        
    }
};
