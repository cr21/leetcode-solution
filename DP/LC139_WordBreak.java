/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Accepted
996,272
Submissions

*/

class Solution {
    HashMap<Integer,Boolean> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet(wordDict);
        dp = new HashMap();
        return dfs(0,"",set, s);
    }
    
    private boolean dfs(int index, String cur, HashSet<String> set, String s ) {
        // System.out.println("cur: "+cur + " index: "+index);
        if(index >= s.length()) {
            
            return true;
        }
       
        if(dp.containsKey(index)) {
            return dp.get(index);
        }
        
        for(int i = index+1;i<= s.length();i++) {
            if(set.contains(s.substring(index,i))) {  
               if(dfs(s.substring(0, i).length(),s.substring(0,i),set, s)) {
                   dp.put(s.substring(0, i).length(), true);
                    return true;
                } 
            }
               
        }
        dp.put(index, false);
        return false;
        
        
    }
}


class Solution {
    HashMap<String,Boolean> dp2;
    HashMap<Integer,Boolean> dp;
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet(wordDict);
        dp = new HashMap();
        dp2= new HashMap();
        return helper(s);
        // return dfs(0,"",set, s);
    }
    
    private boolean helper(String query) {
        if(query.length() == 0) {
            dp2.put(query, true);
            return true;
        }
        
        if(dp2.containsKey(query)) {
            return dp2.get(query);
        } 
        
        for(int i=0;i<query.length();i++) {
            if(set.contains(query.substring(0,i+1)) && helper(query.substring(i+1))) {
                dp2.put(query.substring(i+1), true);
                return true;
            }    
        }
        
        dp2.put(query,false);
        return false;
    }
    
    private boolean dfs(int index, String cur, HashSet<String> set, String s ) {
        // System.out.println("cur: "+cur + " index: "+index);
        if(index >= s.length()) {
            
            return true;
        }
       
        if(dp.containsKey(index)) {
            return dp.get(index);
        }
        
        for(int i = index+1;i<= s.length();i++) {
            if(set.contains(s.substring(index,i))) {  
               if(dfs(s.substring(0, i).length(),s.substring(0,i),set, s)) {
                   dp.put(s.substring(0, i).length(), true);
                    return true;
                } 
            }
               
        }
        dp.put(index, false);
        return false;
        
        
    }
}
