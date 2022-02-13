/*
Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.

 

Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
Output: 3
 

Constraints:

1 <= wordsDict.length <= 105
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
*/

class WordDistance {
    
    HashMap<String,List<Integer>> locationMap;
    String[] wordsDict;
    public WordDistance(String[] wordsDict) {
        locationMap = new HashMap();
        this.wordsDict = wordsDict;
        for(int i=0;i<wordsDict.length;i++) {
            String word = wordsDict[i];
            if(!locationMap.containsKey(word)) {
                locationMap.put(word, new ArrayList());
            }
            
            locationMap.get(word).add(i);
        }
        
    }
    
    public int shortest(String word1, String word2) {
        // get sorted list of indices of word1 and word2 occurances
        List<Integer> location1 = locationMap.get(word1);
        List<Integer> location2 = locationMap.get(word2);
        if(location1.isEmpty() || location2.isEmpty()) return 0;
        int j = 0;
        int k = 0;
        // System.out.println
        
        
        int minDistance = Integer.MAX_VALUE;
        
        // use two pointer approach to find the minimum distance between indices in linear
        // time
        while(j < location1.size() && k < location2.size()){
            minDistance = Math.min(minDistance, Math.abs(location1.get(j)-location2.get(k)));
            
            // if location j is less than location k
            // we should increament j because location indices are sorted 
            // so if we increase j to j+1 we will have chance to reduce distance between
            // j+1 and k
            if(location1.get(j) < location2.get(k)){
                j++;
            }else{
                k++;
            }
        }
        return minDistance;
        
        
        // return 0;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
