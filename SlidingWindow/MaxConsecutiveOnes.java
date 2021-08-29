/*

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length

*/


class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int windowStart = 0;
        int windowEnd = 0;
        int onesCount = 0;
        int maximumOneTillNow = 0;
        int globalLength = 0;
        
        while (windowEnd < nums.length) {
            if(nums[windowEnd] == 1) {
                onesCount++;
            }
            maximumOneTillNow = Math.max(maximumOneTillNow, onesCount);
            
            int currentWindowLength = windowEnd - windowStart +1;
            
            if(currentWindowLength - maximumOneTillNow  > k ) {
                // we need to shrink the window
                if(nums[windowStart] == 1) {
                    onesCount--;
                }
                windowStart++;
                
            }
            
            globalLength = Math.max(globalLength, windowEnd-windowStart+1);
            
            windowEnd++;
        }
        
        return globalLength;
        
    }
}
