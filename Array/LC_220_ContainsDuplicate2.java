*

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
  
  */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int l) {
        HashMap<Integer,Integer> map = new HashMap();
        int k = -1;
        int j = -1;
        // Map<Element, index>
        for(int i=0;i<nums.length;i++) {
            int ele = nums[i];
            if(map.containsKey(ele)) {
                 k = map.get(ele); 
                 if( Math.abs(i-k)<=l) {
                   return true;  
                 }   
            }
            
            // if you don't find the match in map
            // or difference between already found two distinct index is larger than l
            // update current duplicate number with new update indexes 
            map.put(nums[i],i);
            
        }
        // if you loop over all the element and don't find the answer just return false;
        return false;
        
    }
    
}
