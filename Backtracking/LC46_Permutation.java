/*

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        
        backtrack(new ArrayList(), res, nums, new boolean[nums.length]);
        return res;       
    }
    
    private void backtrack(List<Integer> lst, List<List<Integer>> res, int[] nums, boolean [] used) {
        // base case
        // if lst size is same as size of numbers we have reached correct permutation
        if(lst.size() == used.length) {
            
            // deep copy current list into result
            res.add(new ArrayList(lst));
        }
        
        
        for(int i=0;i<used.length;i++) {
            // if current number is already used skip it
            if(used[i]) {
                continue;
            }
            // add number to current result path
            lst.add(nums[i]);
            // check this number to used and set it as true
            used[i] = true;
            
            // call recursive function over children
            backtrack(lst, res, nums, used);
            // now backtrack when function return 
            // remove last added number
            
            lst.remove(lst.size()-1);
            // set it as false as we have already processed the down path
            used[i] = false;
            
            
        }
        
        
        
    }
}
