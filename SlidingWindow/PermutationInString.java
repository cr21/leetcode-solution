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

/*

MORE OPTIMZED SLIDING WINDOW

*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        
        
    if(s1.length() > s2.length()){
            return false;
    }
        
       int [] s1Map = new int[26];
       int [] s2Map = new int[26];
        
        
        
        for(int i =0;i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }
        
        int count = 0;
        
        for(int i=0; i< 26; i++) {
            if(s1Map[i] == s2Map[i]) {
                count++;
            }
        }
        
        
        
        for(int i = 0; i < s2.length() - s1.length();i++) {
            
            
            int r = s2.charAt(i + s1.length()) - 'a';
            int l = s2.charAt(i) - 'a';
            if(count == 26) {
                return true;
            }
            
            
            // add to windowEnd
            s2Map[r]++;
            
            if(s2Map[r] == s1Map[r]){
                count++;
            }else if(s2Map[r] ==  (s1Map[r]+1) ) {
                count--;
            }
            // remove window start
            
            s2Map[l]--;
            if(s2Map[l] == s1Map[l]) {
                count++;
            }else if(s2Map[l] == s1Map[l]-1){
                count--;
            }
            
          
        }
        //  last window check
        return count==26;  
    }
    
    
    
}



/*


ANOTHER SLIDING WINDOW
*/


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1 == null ) return false;
        
        if(s1.length() > s2.length() ) return false;
        
        
        Map<Character, Integer> map = new HashMap();
        int matched = 0;
        int windowStart=0;
        int windowEnd = 0;
        
        for(int i=0;i<s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
        }
        
        while(windowEnd < s2.length()) {
            Character rChar = s2.charAt(windowEnd);
//          IF map contains current windowEnd element 
//          Decrement it's count in hash map if it becomes zero we have found all 
//          the necessary count for this charcter in pattern so increment the matched
            if(map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar)-1);
                if(map.get(rChar) == 0) {
                    matched++;
                }
            }
            
            // if matched count matches the total number of chars in map we get the pattern 
            if(matched == map.size()) {
                return true;
            }
            
            
            // check if we need to shrink the window or not
            // if window end is greater than current window pattern length
            // we need to shrink the window and move
            // shift start pointer to start pointer+1
            if(windowEnd >= s1.length()-1) {
                
                Character lChar = s2.charAt(windowStart++);
                // if map contains elements to be removed
                if(map.containsKey(lChar)) {
                    // if the count of this is zero that means we have enough count for this char but are removing it from map 
                    // so decrement the match count 
                    // we reduced the count by 1 so we have to make it up by adding the count to map
                    if(map.get(lChar) == 0){
                        matched--;
                    }
                    
                    map.put(lChar, map.getOrDefault(lChar,0)+1);
                    
                }
                
                
            }
            
            
            windowEnd++;
        }
        
        return matched == map.size();
        
    }
}
