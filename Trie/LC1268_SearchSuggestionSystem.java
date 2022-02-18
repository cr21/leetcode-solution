https://leetcode.com/problems/search-suggestions-system/solution/

/*

You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 

Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.


*/


class Solution {
    
    public class Trie{
        
        List<String> top3;
        Trie[] children;
        
        public Trie(){
            top3 = new ArrayList();
            children = new Trie[26];
        }
        
    }
    
    Trie root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        System.out.println("products.length"+products.length 
                          + " " + searchWord.length());
            
        root = new Trie();
        addWords(products, root);
        
        Trie current = root;
        
        List<List<String>> res = new ArrayList();
        for(int i=0;i<searchWord.length();i++) {
            char c  = searchWord.charAt(i);
            if(current == null || current.children[c-'a'] == null) {
                res.add(new ArrayList());
                current = null;
                continue;
            }else{
                List<String> topk_matching = prefixMatchingTopK(current,c);
                res.add(topk_matching);
                current = current.children[c-'a'];
            }
            
        }
        return res;
    }
    
    private void addWords(String[] products, Trie root) {
        Arrays.sort(products);
        for(String product : products) {
            Trie cur = root;
            for(int i=0;i<product.length();i++) {
                int location = product.charAt(i)-'a';
                if(cur.children[location] ==null) {
                    cur.children[location] = new Trie();
                }
                // add word to the top3
                
                if(cur.children[location].top3.size()<3) {
                    cur.children[location].top3.add(product);
                }
                cur = cur.children[location];
             }
            
        }
    }
    
    
    private List<String> prefixMatchingTopK(Trie current_root, char prefix_char) {
        int location = prefix_char - 'a';
        if(current_root.children[location] == null) {
            return new ArrayList();
        }else{
            Trie prefixNode = current_root.children[location];
            List<String> r = new ArrayList(prefixNode.top3);
            Collections.sort(r);
            return r; 
        }
        
        
    }
    
    
}
