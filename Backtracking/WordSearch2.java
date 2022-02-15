class Solution {
    int m, n;
    int dirs[][];
    public List<String> findWords(char[][] board, String[] words) {
        dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
        m = board.length;
        n = board[0].length;
        
        Set<String> set = new HashSet();
        for(String word: words) {
            for(int i=0;i< m;i++ ){
                for(int j=0;j<n;j++) {
                    if(board[i][j] == word.charAt(0)) {
                        char[][] deepCopy = getDeep(board);
                        if(dfs(i,j,word, deepCopy, 1)) {
                            set.add(word);
                        }
                    }
                }
            }
        }
        
        return new ArrayList(set);
        
        
        
    }
    
    
    private char[][] getDeep(char[][] original) {
        char[][] result = new char[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
    private boolean dfs(int i, int j, String s, char[][] board, int index) {
        
        if( i < 0 || i >= m || j < 0 || j >= n 
           || board[i][j] == '#') return false;
        
        
        if(index >= s.length()) {
            return true;
        }
        
        char prev = board[i][j];
        
        board[i][j] = '#';
        
        for(int [] dir:dirs){
            int newI = dir[0]+i;
            int newJ = dir[1]+j;
            
            if(newI>=0 && newI < m && newJ >=0 && newJ <n && board[newI][newJ] == s.charAt(index)) {
                if(dfs(newI, newJ, s, board, index+1)){
                    return true;
                }
            }
            
            
        }
        
        board[i][j] = prev;
        return false;
        
    }
}
