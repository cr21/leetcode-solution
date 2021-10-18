/*

Sometimes people repeat letters to represent extra feeling. For example:

"hello" -> "heeellooo"
"hi" -> "hiiii"
In these strings like "heeellooo", we have groups of adjacent letters that are all the same: "h", "eee", "ll", "ooo".

You are given a string s and an array of query strings words. A query word is stretchy if it can be made to be equal to s by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is three or more.

For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has a size less than three. Also, we could do another extension like "ll" -> "lllll" to get "helllllooo". If s = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = s.
Return the number of query strings that are stretchy.

 

Example 1:

Input: s = "heeellooo", words = ["hello", "hi", "helo"]
Output: 1
Explanation: 
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
Example 2:

Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
Output: 3
 

Constraints:

1 <= s.length, words.length <= 100
1 <= words[i].length <= 100
s and words[i] consist of lowercase letters.

*/


class Solution {
    public int expressiveWords(String s, String[] words) {
        
        
        
        if (words == null || words.length ==0 || s == null || s.length() == 0 ) {
            return 0;
        }
        int count = 0;
        for(String word: words) {
            if(isValid( word,s)) {
                count+=1;
            }
        }
        
        return count;
    }
    
    private int getrepeatingLength(int ptr, String word) {
        int tmp = ptr;
        
        while(tmp < word.length() && word.charAt(tmp) == word.charAt(ptr)){
            tmp+=1;
        }
        
        return tmp-ptr;
        
        
    }
    
    private boolean isValid(String word, String p) {
        
        int w1 = word.length() ;
        int p1 = p.length() ;
        
        int w_ptr = 0;
        int p_ptr = 0;
        
        char[] words = word.toCharArray();
        char[] ps = p.toCharArray();
        
        while(w_ptr < w1 && p_ptr  < p1) {
            
            if(words[w_ptr] != ps[p_ptr]){
                return false;
                
            }
            
            // get number of times the char repeat in word
            int len1 = getrepeatingLength(w_ptr, word);
                
            // get number of times the char repeat in pattern
            int len2 = getrepeatingLength(p_ptr, p);
            
            
            if(len2 < 3 && len1 != len2  || len2 >= 3 && len2 < len1 ) {
                return false;
            }
            
            
            w_ptr += len1;
            p_ptr += len2;
            
            
        }
        
        if( w_ptr == word.length()  && p_ptr == p.length()) {
            return true;
        }
        
        return false;
        
        
    }
}
