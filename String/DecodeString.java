/*

    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

    Example 1:

        Input: s = "3[a]2[bc]"
        Output: "aaabcbc"
    Example 2:

        Input: s = "3[a2[c]]"
        Output: "accaccacc"
    Example 3:

        Input: s = "2[abc]3[cd]ef"
        Output: "abcabccdcdcdef"
    Example 4:

        Input: s = "abc3[cd]xyz"
        Output: "abccdcdcdxyz"


*/


/*

    Time complexity : O(N*K) N  is the length and K is the no of times string might be repeated in output
    Spacecomplexity : O(N*K)
    is worked on leetcode : YES
*/

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        
        Integer curr_num = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder curr_str = new StringBuilder();
        Stack<Integer> num_st = new Stack();
        Stack<StringBuilder> str_st = new Stack();
        for(int i =0 ;i < s.length();i++){
            Character c = s.charAt(i);
            // case 1 Integer
            
            if(Character.isDigit(c)){
                curr_num = curr_num * 10 + c - '0';
            }
            
            
            // case 2 open bracket
            else if(c == '['){
                num_st.push(curr_num);
                str_st.push(curr_str);
                curr_num = 0;
                curr_str =  new StringBuilder();
            }
            
            
            // case 3 close bracket
            else if(c == ']'){
                Integer num = num_st.pop();
                StringBuilder new_str = new StringBuilder();
                for(int  k =0;k < num; k++){
                    new_str.append(curr_str);
                }
                curr_str = str_st.pop().append(new_str); 
            }
            // case 4 charchter
            else{
                curr_str.append(c);
            }
        }
        return curr_str.toString();
    }
}

/*

Recursion Algorithm

int i = 0;
    
    public String decodeString(String s) {
        
        if (s == null  || s.length() == 0)  return s;
        
        Integer curr_num = 0;
        StringBuilder result = new StringBuilder();
        
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                i++;
                curr_num = curr_num * 10 + c - '0';
                
            }
            // if you encounter open bracket that means you will recursively call the function
            else if(c == '['){
                i++;
                String inner = decodeString(s);
              
                for(int k =0;k < curr_num;k++){
                    result.append(inner);
                }
                curr_num = 0;
                
            }
            
            // return you encounter closing bracker
            else if(c == ']'){
                i++;
                return result.toString();
            }
            else{
                i++;
                result.append(c);
            }        
        }
        
        return result.toString();
    }

*/