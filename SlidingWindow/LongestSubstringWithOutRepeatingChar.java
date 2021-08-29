/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.


*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        HashMap<Character, Integer> counter = new HashMap();
        if(s == null ){
            return 0;
        } 
        if(s.length() <=1){
            return s.length();
        }
        int right=0;
        int left = 0;
        int global = 0;
        while(right < s.length() ){
            Character rChar = s.charAt(right);
            if(!counter.containsKey(rChar)) {
                counter.put(rChar, 1);
            } else{
              
//               if you find repeat char update the global
//                move window left till you find only one occurance of current window end char and then continur moving and sliding
                global = Math.max(global, right-left);
                //global = Math.max(global,curr);
                while(counter.containsKey(rChar)) {
                    Character currLeft = s.charAt(left);
                    counter.put(currLeft, counter.get(currLeft)-1);                    
                    counter.remove(currLeft, 0);
                    left++;
                }
                counter.put(rChar, 1);    
            }
            right++;
            global = Math.max(global,right-left);      
        }
        return global;
        
    }
}


/*

// no need to maintain count store the index of character instead
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
        HashMap<Character, Integer> counter = new HashMap();
        
        int right=0;
        int left = 0;
        int global = 0;
        
        for(;right < s.length();right++ ) {
            Character  rightChar = s.charAt(right);
            if(counter.containsKey(rightChar)) {
                left = Math.max(left, counter.get(rightChar));
            }
            global = Math.max(global, right-left+1);
            counter.put(rightChar, right+1);
        }
        
        return global;
        
    }
}

*/
