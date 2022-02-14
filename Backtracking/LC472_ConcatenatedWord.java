
/*
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

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
    HashMap<String, Boolean>  map;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set = new HashSet();
        map = new HashMap();
        List<String> result = new ArrayList();
        
        for(String word:words) {
            set.add(word);
        }
        
        for(String word: words) {
            if(dfs(word, set, 1)){
                map.put(word, true);
                result.add(word);
            }
        }
        
        return result;     
    }
    
    private boolean dfs(String word, HashSet<String> set, int count) {
        if(set.contains(word) && count > 1) {
            return true;
        }
        
        if(map.containsKey(word)) {
            return map.get(word);
        }
        
        for(int i=1;i<word.length(); i++) {
            if(set.contains(word.substring(0,i)) && dfs(word.substring(i), set, count+1)) {
                map.put(word, true);
                return true;
            }
        }
        map.put(word, false);
        return false;
    }
}
