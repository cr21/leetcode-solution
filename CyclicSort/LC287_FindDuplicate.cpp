/*

287. Find the Duplicate Number
Medium

9491

965

Add to List

Share
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 
*/

/*
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
      
        for(int i=0;i< nums.size();i++) {
              int _abs = abs(nums[i]);
              if(nums[_abs-1] < 0) {
                  return abs(nums[i]);
              }else{
                  nums[_abs-1] *= -1;
              }
          }
    }
  
  
}
*/

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        for(int i=0;i< nums.size();i++) {
            int _abs = abs(nums[i]);
            if(nums[_abs-1] < 0) {
                return abs(nums[i]);
            }else{
                nums[_abs-1] *= -1;
            }
        }
        
        int i=0;
        while(i < nums.size()) {
            if(nums[i] == nums[nums[i]-1]) {
                i++;
            }else{
                swap(nums, i, nums[i]-1);   
            }
        }
        
        for(int i=0;i< nums.size();i++) {
            if(nums[i]!=i+1){
                return nums[i];
            }
        }
        return -1;
        
    }
    static void swap(vector<int> &arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
};
