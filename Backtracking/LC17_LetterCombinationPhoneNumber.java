/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Mapping: 

'2', "abc"
'3',"def"
'4',"ghi"
'5',"jkl",
'6',"mno"
'7',"pqrs"
'8',"tuv"
'9',"wxyz"

 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


*/

class Solution {
    Map<Character, char[]> mapping;
    public List<String> letterCombinations(String digits) {
        
        if(digits == null || digits.length() == 0) return new ArrayList();
        mapping =Map.of(
        '2', "abc".toCharArray(),
        '3',"def".toCharArray(),
        '4',"ghi".toCharArray(),
        '5',"jkl".toCharArray(),
        '6',"mno".toCharArray(),
        '7',"pqrs".toCharArray(),
        '8',"tuv".toCharArray(),
        '9',"wxyz".toCharArray()
        );
        
        
        List<String> lst = new ArrayList();
        
        
        backtrack(new StringBuilder(), lst, digits.toCharArray());
            
            
        
        return lst;
        
        
    }
    
    private  void backtrack(StringBuilder path, List<String> res, char[] digits) {
        
        // base case
        if(path.length() == digits.length) {
            res.add(path.toString());
            return;
        }
        
        
        Character next_digit = digits[path.length()];
        
        for(Character letter: mapping.get(next_digit)) {
            path.append(letter);
            // iterateover children recursion
            backtrack(path, res, digits);
            // remove letter
            // backtrack
            path.deleteCharAt(path.length()-1);
            
            
        }
        
        
        
        
        
    }
}
