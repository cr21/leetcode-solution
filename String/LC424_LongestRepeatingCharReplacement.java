/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length

*/

class Solution {
    public int characterReplacement(String s, int k) {
        
        int left ;
        int right;
        int maxlen = 0;
        int current_window_best = 0;
        HashMap<Character, Integer> counter = new HashMap();
        for(left = 0,right=0;right< s.length(); right++) {
            char r = s.charAt(right);
            counter.put(r, counter.getOrDefault(r,0)+1);
            // maximum frequency of char in current window
            current_window_best = Math.max(current_window_best, counter.get(r));
            
            
            int current_window_length = right-left+1;
            
            // we are in limit of using max 2 char for replacement
            // if we breach the limit we will shrink the current window and 
            // continue
            if(current_window_length - current_window_best > k) {
                char l= s.charAt(left);
                counter.put(l, counter.get(l)-1);
                left++;
            }
            maxlen = Math.max(right-left+1, maxlen);
        
    }
        return maxlen;
}
    
}
