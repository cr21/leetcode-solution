/**

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 3 dots in word for search queries.
At most 104 calls will be made to addWord and search.

**/

class WordDictionary {
    public class TrieNode {
        HashMap<Character, TrieNode> children;
        String word;
        
        TrieNode() {
            children = new HashMap();
            word=null;
        }
    }
    
    
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            
            if(!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }
            current = current.children.get(ch);
        }
        
        current.word = word;
    }
    
    public boolean search(String word) {
        return dfs(word, root);
    }
    
    private boolean dfs(String word, TrieNode root) {
        for(int i=0;i< word.length();i++) {
            
            char ch = word.charAt(i);
            int index = ch-'a';
            // if ch is not in current children 
            if(!root.children.containsKey(ch)) {
                if(ch == '.') {
                    for(Character ch1: root.children.keySet()) {
                        // . match any character so we will search next index to end of index subtring with children node
                        if(dfs(word.substring(i+1),root.children.get(ch1)) ) return true;
                    }
                }
                // current node does not contains char and it is also not special characters
                return false;
            }else{
                root = root.children.get(ch);
            }     
        }
        
        // if you reach end of the word 
        // check if current node word is actual word in dictionary else return false
        return !(root.word == null);
            
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
