/**
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

**/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> li  = new ArrayList();
        
        
        
        if(s == null || p == null || s.length()  == 0 || p.length() == 0 || p.length() > s.length() )           {
            return li;
        }
        
        int left = 0;
        int right ;
        char [] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String sortedp = String.valueOf(pArr);
       
        for(right = p.length() -1; right < s.length() ; right++ ) {
            String sub = s.substring(left, right+1);
            char [] subArr = sub.toCharArray();
            Arrays.sort(subArr);
            String sortedSub = String.valueOf(subArr );
            if(sortedp.equals(sortedSub) ) {
                li.add(left);
            }
            left++;
        
            
        }
        return li;
    }
    
    
  
    
    
}
