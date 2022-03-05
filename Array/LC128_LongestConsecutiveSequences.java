/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        System.out.println(nums.length);
        int maxLength = 0;
        HashSet<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            // check if previous elements exist or not
            int currentLength=0;
            if(!set.contains(num-1)) {
                // check forward
                while(set.contains(num)) {
                    currentLength++;
                    num+=1;
                }
                
            }
            maxLength = Math.max(maxLength, currentLength);
     }
        
        
        return maxLength;
        
    }
}
