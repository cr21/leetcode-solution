/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

*/


class Solution {
    HashMap<String,String> map ;
    int st;
    int e;
    public String longestPalindrome(String s) {
        map = new HashMap();
        
        
        // return getPallindromic(s);
        char [] c_ar = s.toCharArray();
        for(int i =0;i<c_ar.length;i++) {
            helper(i,i,c_ar);
            helper(i,i+1,c_ar);
        }
        return s.substring(st,e+1);
    }
    
    private void helper(int left, int right, char[] c_ar) {
        
            while(left >= 0 && right < c_ar.length && c_ar[left] == c_ar[right]) {
                left--;
                right++;
                
            }
            left++;
            right--;
            
            if(right-left > (e-st)) {
                st=left;
                e= right;
            }
            
        
    }
   
}


