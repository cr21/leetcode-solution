
/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> desired = new HashMap();
         // Dictionary which keeps a count of all the unique characters in t.
        for(Character ch : t.toCharArray()) {
            Integer count = desired.getOrDefault(ch, 0);
            desired.put(ch, count+1);        
        }
        
//         number of uniqueu character from t should be present in s
        int required = desired.size();
        
        int l = 0;
        int r = 0;
        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounter = new HashMap();
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed  = 0;
        
        // length of the substring, left and right pointer
        // ans list of the form (window length, left, right)
        int ans[] = {-1,0,0};
        
        while( r < s.length()) {
            // Add one character from the right to the window
          
            char ch = s.charAt(r);
            int current_count = windowCounter.getOrDefault(ch,0);
            windowCounter.put(ch, current_count+1);
            // If the frequency of the current character added equals to the
          // desired count in t then increment the formed count by 1.
            if(desired.containsKey(ch) && windowCounter.get(ch).intValue() == desired.get(ch).intValue()) {
                formed++;
            }
            
            // if formed  ==. required then contract the window till it is no longer desireable window
            while(l <= r && formed == required) {
                ch = s.charAt(l);
                // before removing char from current window
                // update the current window
                if(ans[0]==-1 || r-l+1 < ans[0]) {
                    // update 
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // removing char from current window
                 
                // The character at the position pointed by the
              // `Left` pointer is no longer a part of the window.
              
                windowCounter.put(ch, windowCounter.get(ch)-1);
                if(desired.containsKey(ch) && windowCounter.get(ch).intValue() < desired.get(ch).intValue()) {
                    formed--;
                }
                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }
            
            // Keep expanding the window once we are done contracting.
            r++;
            
            
        }
        
        return ans[0] == -1? "": s.substring(ans[1], ans[2]+1);
        
        
        
    }
}
