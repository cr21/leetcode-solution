/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
  */

// top down backtracking with marking dp array

  class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        
        // we will mark dp array as 0,1,-1 
        // dp[index] == 0 means we haven't completely processed this index
        // dp[index] == 1 means we can reach to the last positing from this index
        // dp[index] == -1 means we can not reach to the last position from this index
        
        Arrays.fill(dp,0);
        // from last position we can always reach last index so mark it as 1
        dp[nums.length-1]= 1;
        return dfs(nums,0, dp);
        
    }
    
    private boolean dfs(int[] nums, int index, int[] dp) {
        
        // if current index is not 0 that means it is either 1 or -1 
        // if it is 1 return true else return false
        if(dp[index] != 0) {
            return dp[index]==1 ? true : false;
        }
        
        // largest jump possible from current position
        int largestJump = Math.min(index+nums[index], nums.length-1);
        
        for(int nextPos= index+1;nextPos<= largestJump;nextPos++) {
            // if we can reach from next position 
            // mark the current index as reachable
            if(dfs(nums, nextPos, dp)) {
                    dp[index]=1;
                    return true;
                }
        }
        
        // mark current index as non reachable
        dp[index]=-1;
        return false;
        
        
    }
}


class Solution {
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        
        // we will mark dp array as 0,1,-1 
        // dp[index] == 0 means we haven't completely processed this index
        // dp[index] == 1 means we can reach to the last positing from this index
        // dp[index] == -1 means we can not reach to the last position from this index
        
        Arrays.fill(dp,0);
        // from last position we can always reach last index so mark it as 1
        dp[nums.length-1]= 1;
        
        // Bottom up dp
        
        for(int i=nums.length-2;i>=0;i--) {
            int furthestJumpIndex = Math.min(i+nums[i], nums.length-1);
            
            for(int j = i+1;j<=furthestJumpIndex;j++) {
                // If we reach to final index from j 
                // that means we could reach to final index from i 
                
                if(dp[j] == 1){
                    dp[i] = 1;
                    break;
                }
            }     
        }
        
        return dp[0]==1;
        // top down dp
        // return dfs(nums,0, dp);
        
    }
    
    private boolean dfs(int[] nums, int index, int[] dp) {
        
        // if current index is not 0 that means it is either 1 or -1 
        // if it is 1 return true else return false
        if(dp[index] != 0) {
            return dp[index]==1 ? true : false;
        }
        
        // largest jump possible from current position
        int largestJump = Math.min(index+nums[index], nums.length-1);
        
        for(int nextPos= index+1;nextPos<= largestJump;nextPos++) {
            // if we can reach from next position 
            // mark the current index as reachable
            if(dfs(nums, nextPos, dp)) {
                    dp[index]=1;
                    return true;
                }
        }
        
        // mark current index as non reachable
        dp[index]=-1;
        return false;
        
        
    }
}
