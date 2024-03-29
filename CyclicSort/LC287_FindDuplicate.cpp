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


/*

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        int low = 1;
        int high = nums.size();
        int duplicate = -1;
        auto small_or_eq = [&](int mid) {
            int count = 0;
            for(auto & i: nums){
//              count number of element that are less or equals to mid element
                if(i <= mid){
                    count++;
                }
            } 
            return count;
        };
        
        while(low <= high) {
            int mid = (low + high)/2;
            //    count number of element that are less or equals to mid element
            //    if count is greater than mid then we find the number that is duplicate
            //    we want to find the smallest number that has count greater than mid so we will search in lower part
            if(small_or_eq(mid) > mid) {
                duplicate = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return duplicate;
        
    }
};

*/


/*

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        int turtle = nums[0];
        int rabbit = nums[0];
        // rabbit will go twice the speed of turtle
        do{
            turtle = nums[turtle];
            rabbit = nums[nums[rabbit]];
        }while(turtle != rabbit);
        
        
        // move turtle to start of the array 
        // now traverse rabbit and turtle at same speed
        turtle = nums[0];
        while(turtle != rabbit) {
            turtle = nums[turtle];
            rabbit = nums[rabbit];
        }
        
        return rabbit;
    }
};
*/
