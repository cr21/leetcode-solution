class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first_found_index = binary_search(nums, target, 0, nums.length-1, true);
        
        int last = binary_search(nums, target, 0, nums.length-1, false);
        
        return new int[]{first_found_index,last };
    }
    
    
    private int binary_search(int[]nums, int target, int left, int right, boolean isFirst) {
        
        
        while(left <= right) {
            
            int mid = left + (right-left)/2;
            
            // if we reach target
            // there are two case
            if(nums[mid] == target) {
                // case 1: if we finding the bound for first occurance of targetr
                if(isFirst){
                    // if mid is first element return it, or if previous index of mid < mid element we got our index
                    if(mid == 0 || nums[mid-1]!= nums[mid]) {
                        return mid;
                    }else{
                        // if not we can still have same target element on mid-1 so search in left subarray of mid 
                        right = mid-1;
                    }
                }else{
                    // if mid is last element return it, or if next index of mid > mid element we got our index
                    
                    if(mid == nums.length-1 || nums[mid+1]!= nums[mid]) {
                        return mid;
                    }else{
                        // if not we can still have same target element on mid+1 so search in right subarray of mid 
                        
                        left = mid+1;
                    }
                }
                
            // if current element at mid is greater than target than target is in left subarray of mid
            }else if(nums[mid] > target) {
                right = mid-1;
            }else{
                // else it is in right subarray of mid
                left = mid+1;
            }
        }
        
        // we did not find element
        return -1;
        
        
        
    }
    
    
    
}
