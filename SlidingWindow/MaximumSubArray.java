/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105
  
  */
class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // edge case
        if(nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = 1;
        
        int currSum = nums[left];
        int globalSum = nums[left];
        while(right < nums.length) {
            if(currSum < 0) {
                currSum = nums[right];
                left = right;
            }else{
                currSum += nums[right];
            }
            globalSum = Math.max(globalSum, currSum); 
            right++;
        }
        
        return globalSum;
        
    }
}
