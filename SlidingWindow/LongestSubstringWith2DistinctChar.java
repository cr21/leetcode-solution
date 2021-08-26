/**
Given a string s, return the length of the longest substring that contains at most two distinct characters.

 

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.
 

Constraints:

1 <= s.length <= 105
s consists of English letters.

*/


class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int k=2;
        Map<Character, Integer> counter = new HashMap();
        
        if(s == null || k == 0 ) return 0;
        
        if(s.length() <=k ) return s.length();
        
        int left = 0;
        int curr = 0;
        int global = 0;
        int right = 0;
        while(right < s.length()) {
            
//             if map already contains key increment the counter
            if(counter.containsKey(s.charAt(right))) {
                counter.put(s.charAt(right), counter.get(s.charAt(right)) + 1);
                curr++;
            }else{
                
//                  if map size is less than two we can add the fruit in new basket and increment the counter
                if(counter.size() <k) {
                    counter.put(s.charAt(right),1);
                    curr++;
                }else{
//                     if we already picked two different fruits we need  to update the maximum number of fruits till now
//                      add third basket Temporarily   and increment current counter
                    global = Math.max(global, curr);
                    counter.put(s.charAt(right),1);
                    curr++;
//                  keeps on increment left pointer (remove the element) till the map has two types of fruits basket left
                    while(counter.size()!= k) {
                        //decrement the size of fruits in basket
                        counter.put(s.charAt(left), counter.get(s.charAt(left))-1);
                        // remove the basket when it becomes empty
                        counter.remove(s.charAt(left),0);
                        left+=1;
                        curr--;
                    }
                } 
            }
            global = Math.max(global, curr);
            right++;
        }
        return global;
        
    }
}
