/*

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
 

*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        if(p == null || s == null) return new ArrayList();
        if(p.length() > s.length()) return new ArrayList();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        
        List<Integer> res=new ArrayList();
        
        for(int i=0;i<p.length(); i++) {
            map1[p.charAt(i)-'a']++;
            map2[s.charAt(i)-'a']++;
            
        }
        int i=0;
        for(i=0;i<s.length()-p.length(); i++) {
            
            if(matches(map1, map2)) {
                res.add(i);
            }
            Character lch = s.charAt(i);
            Character rch = s.charAt(i + p.length());
            map2[lch-'a']--;
            map2[rch-'a']++;
        }
        
        if(matches(map1, map2)){
            res.add(i);
        }
        
        return res;
        
    }
    
    private boolean matches(int[] map1, int[] map2) {
        for(int i=0; i<map1.length;i++) {
            if(map1[i] != map2[i])return false;
        }
        
        return true;
    }
}
