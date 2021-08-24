/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray 
[numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

https://leetcode.com/problems/minimum-size-subarray-sum/ 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 
 
 
*/


// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
        
//         int left = 0;
//         int minLength = Integer.MAX_VALUE;
//        // int minLength = 0;
    
//         int currSum = 0;
//         for(int i = 0; i < nums.length; i++){            
//             currSum += nums[i];
//              while(currSum >= target) {
//                     minLength = Math.min(minLength, i+1-left);
//                     currSum -= nums[left++];
//                 }     
//         }
        
        
//        return minLength != Integer.MAX_VALUE ? minLength : 0;
//     }
// }

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int minLength = Integer.MAX_VALUE;
       // int minLength = 0;
    
        
        for(int i = 0; i < nums.length; i++){            
            int currSum = 0;
            for(int j = i; j< nums.length;j++) {
                currSum += nums[j];
                if(currSum >= target) {
                    minLength = Math.min(minLength, j+1-i);
                    break;
                }  
            }
        }
        
        
       return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
