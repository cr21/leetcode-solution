/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 

Constraints:

1 <= s.length <= 20
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 10
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.


*/

import java.util.StringJoiner;
class Solution {
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet(wordDict);
        
        List<String> res = new ArrayList();
        
        dfs(0,s, res, set, new ArrayList());
        return res;
        
        
    }
    
    private void dfs(int start, String s, List<String> res, HashSet<String> set, List<String> path) {
        // base case
        if(start >=s.length()) {
            
            StringJoiner sj= new StringJoiner(" ");
            for(String p : path) {
                sj.add(p);
                
            }
            res.add(sj.toString());
            return;      
        }
        
        for(int i = start+1;i<= s.length();i++) {
            String w = s.substring(start,i);
            if(set.contains(w)) {
                path.add(w);
                dfs(start + w.length(),s, res, set,path);   
                path.remove(path.size()-1);
            }  
        }
        
        
        
        
    }
}


// 2nd solution dp

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        
        HashMap<String, List<String>> memo = new HashMap();
        HashSet<String> set = new HashSet(wordDict);
        return helper(s,set, memo );
    }
    
    private List<String> helper(String query, HashSet<String> wordSet, HashMap<String, List<String>> memo) {
//         if already cached return it
        if(memo.containsKey(query)) {
            return memo.get(query);
        }
        
        List<String> result = new ArrayList();
        
//         if empty return empty string list
        if(query.length() == 0) {
            result.add("");
            return result;
        }
        
//         iterate over every word in dictionary and check if that word is prefix in query
        for(String word:wordSet) {
            
//             if query prefix present in wordDict
            if(query.startsWith(word)) {
//                  prefix present in dictionary so check for suffix
//                 get result for suffix string and append to the result
                List<String> subResult = helper(query.substring(word.length()), wordSet, memo);
                for(String s : subResult){
                    result.add(word + (s.isEmpty() ? "" : " ") + s);  
                }
            }
            
            memo.put(query, result);
        }
        
        return result;
    }
}
