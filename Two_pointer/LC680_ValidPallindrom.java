/*

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/

class Solution {
    public boolean validPalindrome(String s) {
        
        
        int left = 0;
        int  right = s.length()-1;
        
        while(left < right) {
            // if char match then increase left and decrese right pointer
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else{
                // delete at most one character  so
                // there are two option check two substring if it is pallindrome or not
                // by removing right and left resepectevely
                boolean s1=isPallindromic(s, left + 1, right);
                boolean s2=isPallindromic(s, left, right - 1);
                return s1 || s2;
            }    
        }
        
        return true;
    }
    
     private boolean  isPallindromic(String s, int l, int r) {
        
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
            
        }
        
        return true;
        
    }
}
