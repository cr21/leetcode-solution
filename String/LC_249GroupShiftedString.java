/*
We can shift a string by shifting each of its letters to its successive letter.

For example, "abc" can be shifted to be "bcd".
We can keep shifting the string to form a sequence.

For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

 

Example 1:

Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
Example 2:

Input: strings = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strings.length <= 200
1 <= strings[i].length <= 50
strings[i] consists of lowercase English letters.

*/


class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        
        HashMap<String, List<String>>  map = new HashMap();
        
        
        for(String str:strings) {
            
            String key = getKey(str);
            map.putIfAbsent(key , new ArrayList());
            List<String> strs = map.get(key );
            strs.add(str);
            map.put(key , strs);
        }
        
        System.out.println("map "+map);
        
        List<List<String>> res = new ArrayList();
        for(List<String> strs : map.values()) {
            res.add(strs);    
        }
        
        return res;
        
    }
    
    private String getKey(String s) {
        
        
         String key = "";
        
        
        char[] arr = s.toCharArray();
        
        for(int i=1;i<arr.length; i++) {
            
            int diff = arr[i-1] - arr[i];
            if(diff < 0) {
                diff += 26;
            }
            
            key+=diff;
            key+=",";
        }
        
        return key;
        
        
        
    }
}
