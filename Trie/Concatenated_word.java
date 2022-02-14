/*Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 

Constraints:

1 <= words.length <= 104
0 <= words[i].length <= 30
words[i] consists of only lowercase English letters.
0 <= sum(words[i].length) <= 105
  
  */
  
  class Solution {
    
    class TrieNode{
        String word;
        TrieNode[] children = new TrieNode[26];
    }
    
    TrieNode root = new TrieNode();
    
    private void addWord(String word) {
        TrieNode cur = root;
        
        for(int i=0;i<word.length();i++) {
            int ch = word.charAt(i) - 'a';
            if(cur.children[ch] == null) {
                cur.children[ch] = new TrieNode();
            }
            cur = cur.children[ch];
        }
        cur.word = word;  
    }
    
    private List<String> findAllWords(String[] words) {
        List<String> res = new ArrayList();
        for(String word: words) {
            if(dfs(0, word, false)) {
                res.add(word);
            }
        }
        return res;
    }
    
    private boolean dfs(int start,  String word, boolean isConcat)  {
        
        if(start == word.length()) {
            return isConcat;
        }
        
        TrieNode cur = root;
        for(int i=start;i< word.length();i++) {
            int ch = word.charAt(i)-'a';
            if(cur.children[ch] == null) return false;
            if(cur.children[ch].word !=null) {
                if(dfs(i+1,  word,  i == word.length() -1 ? isConcat:true)) {
                    return true;
                } 
            }
            cur = cur.children[ch];
        }
        return false;
        
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        for(String str: words) {
            addWord(str);
        }
        
        return findAllWords(words);
    }
}
