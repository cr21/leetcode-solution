/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.



*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        
        
        if(s1.length() > s2.length()){
            return false;
        }
        
       int [] s1Map = new int[26];
        
        for(int i =0;i<s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i <= s2.length() - s1.length();i++) {
            
            int [ ]s2Map = new int[26];
            
            for(int j=0;j< s1.length();j++) {
                s2Map[s2.charAt(i+j) - 'a']++;
            }
            
            if(matches(s1Map,s2Map)) {
                return true;
            }
        }
        
        return false;
        
    }
    
    
    private boolean matches(int[] map1, int[] map2) {
        
        for(int i=0; i<  26;i++) {
            if(map1[i] !=map2[i]){
                return false;
            }
        }
        
        
        return true;
    }
}



/*

Optimized using Sliding Window:




*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        
        
    if(s1.length() > s2.length()){
            return false;
    }
        
       int [] s1Map = new int[26];
       int [] s2Map = new int[26];
        
        
        
        for(int i =0;i<s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < s2.length() - s1.length();i++) {
            if(matches(s1Map,s2Map)) {
                return true;
            }
            
            // remove the first element because this element is going out from window
            s2Map[s2.charAt(i)-'a']--;
            // add new element into window end
            s2Map[s2.charAt(i+s1.length()) - 'a']++;
        }
        //  last window check
        return matches(s1Map, s2Map);   
    }
    
    
    private boolean matches(int[] map1, int[] map2) {
        
        for(int i=0; i<  26;i++) {
            if(map1[i] !=map2[i]){
                return false;
            }
        }
        
        
        return true;
    }
}
