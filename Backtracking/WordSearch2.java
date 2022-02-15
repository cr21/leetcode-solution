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



/*
Optimized with Trie with backtracing

*/

class Solution {
    
    List<String> res = new ArrayList();
    char[][] _board = null;
    int m;
    int n;
    int [][] dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    class TrieNode {
        TrieNode() {
            
        }
        
        String word = null;
        
        HashMap<Character,TrieNode> children = new HashMap();
        
        
      }
    
    public List<String> findWords(char[][] board, String[] words) {
        // add words to Trie
        m = board.length;
        n = board[0].length;
        TrieNode root = new TrieNode();
        
        // add words to trie
        for(String word: words) {
            TrieNode cur = root;
            
            for(int i=0;i<word.length();i++) {
                Character ch = word.charAt(i);
                if(!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new TrieNode());
                }
                cur = cur.children.get(ch);
            }  
            cur.word = word;  
        }
        
        this._board  = board;
        
        
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                Character ch = _board[i][j];
                // if character at location i and j are children of root or there is word starting at current i and j cell run backtrack
                if(root.children.containsKey(ch)) {
                    dfs(i,j, root);
                }   
            }
        }
        
        return res;
    }
    
    
    private void dfs(int i, int j, TrieNode parent) {
        // get current location letter
        Character letter = this._board[i][j];
        // check if parent has children starting with character at current cell
        TrieNode currNode = parent.children.get(letter);
        
        // if we find character and it is the word that means we found the word in trie which is in board and dictionary we will add it to answer
        if(currNode.word != null ){
            res.add(currNode.word);
            currNode.word = null;
        }
        
        // mask current location so that we won't repeatedly visit the same state
        _board[i][j] = '#';
        
        // iterate over North, south, east, and west direction
        for(int[] dir: dirs) {
            
            
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            
            if(newI < 0 || newI >= m || newJ <0 || newJ >= n ){
                continue;
            }
            
            // if letter at new location is children of current node
            // run dfs over childrent of current node
            if(currNode.children.containsKey(this._board[newI][newJ])) {
                dfs(newI, newJ, currNode);
            }
        }
        
        // unmaks the cell location with original content before leaving
        this._board[i][j] = letter;
        
        
        
    }
}
