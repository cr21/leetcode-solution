/**

C++

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        
        // map to hold <running sum, count>
        unordered_map<int, int> map;
        map[0] = 1;        
        int runningSum = 0;
        int counter = 0;
        
        for(int i =0;i< nums.size(); i++) {
            
            runningSum += nums[i];
            // if running sum not in map
            int complement = runningSum-k;
            
            if(map.find(complement) != map.end()) {
                counter += map.find(complement)->second;
            
            }
            
            
            if(map.find(runningSum) == map.end()) {
                map[runningSum] =0;
            }
            
            map[runningSum]  = map.find(runningSum)->second + 1;
            
            
        }
        
      
        
        return counter;
        
        
        
    }
};

**/


/*

Time Complexity : O(N) N size of input
Space Complexity O(N)
Is worked on leetcode : YES

*/

class SubarrayHavingSumK {
    public int subarraySum(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0,1);
        int cummSum = 0;
        int count = 0;
        
        for(int  i = 0; i<nums.length; i++){
            // maintain cummulative sum
            cummSum+=nums[i];
            // get the complement
            int complement = cummSum-k;
            // if complement is in the map that means 
            // K is already there so increment counter
            if(map.containsKey(complement)){
                count += map.get(complement);
            }
        //    if map dont contains key cummsum then put it in map 
            if(!map.containsKey(cummSum)){
                map.put(cummSum,0);
            }
            // if cummsum is already present then increment it
            map.put(cummSum,map.get(cummSum)+1);
        }      
        return count;
    }
}
