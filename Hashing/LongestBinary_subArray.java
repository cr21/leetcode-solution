/*

Brute force

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        int _max = INT_MIN;
        
        
        for(int i =0; i< nums.size();i++) {
            int ones = 0;
            int zeros =0;
            if(nums[i] ==0) {
                zeros++;
            }else{
                ones++;
            }
            for(int j = i+1; j< nums.size();j++) {
                if(nums[j] == 1){
                    ones++;
                }else{
                    zeros++;
                }
                
                if(zeros == ones) {
                    _max = std::max (_max, j-i+1); 
                }
                
                
            }
        }
        
        if(_max == INT_MIN) return 0;
        return _max;
        
    }
};

*/


/*
 Time Complexity :  O(N)
 Space Complexity : O(N)
 is Worked on leetcode : YES

 */


/*

JAVA
public class LongestBinary_subArray {

//     1010111100101
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer>map =  new HashMap<Integer, Integer> ();
        map.put(0,-1);
        int cummSum = 0;
        int max_len = 0;
        for(int i=0;i<nums.length; i++){
//             if element is zero then reduce sum  by 1 else add sum by 1
            if(nums[i] == 0){
                cummSum -= 1;
            }else{
                cummSum += 1;
            }
//              if map dont have cummsum put that into map
//             else update the maximum length because if you see cummsum again that means that the 
//             array have same num of zeros and one after that cummsum
            if(!map.containsKey(cummSum)){
                map.put(cummSum,i);
            }else{
                int len = i - map.get(cummSum);
                if(len > max_len){
                    max_len = len;
                }
            }
        }
        return max_len;
        
        
    }
}


*/
class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        
        
        if(nums.empty()) return 0;
        int globalmax = 0;
        unordered_map<int, int> umap;
        umap[0] = -1;
        int cummSum = 0;
        for(int i =0; i< nums.size();i++) {
            //cummSum += nums[i] == 1 ? 1 : -1;
            if(nums[i]==1) {
                cummSum++;
            }else{
                cummSum--;
            }
            
            // cumm sum not found
            if(umap.find(cummSum) == umap.end() ) {
                umap[cummSum] = i;
            }else{
                globalmax = std::max(globalmax, i- umap.find(cummSum)->second);
            }
        }
        
        return globalmax;
        
    }
};
