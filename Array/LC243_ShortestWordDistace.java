class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
    
        int minDist = Integer.MAX_VALUE;
        
        int id1 = -1;
        int id2=-1;
      // note down id of the latest index of word1 and word2
      // when you found both id calculate the distance and move on
      
        for(int i=0;i<wordsDict.length; i++) {
            
            if(wordsDict[i].equals(word1)) {
                id1 = i;
            }
            else if(wordsDict[i].equals(word2)) {
                id2= i;
            }
            if(id1 != -1 &&  id2!=-1) {
                minDist = Math.min(minDist, Math.abs(id1-id2));
            }
            
            // if(minDist == 1)return 1;
        }
        
        return minDist;
        
    }
}
