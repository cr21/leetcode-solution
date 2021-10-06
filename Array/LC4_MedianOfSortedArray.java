/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

*/


class Solution {
    
    // 1 7 8 10 11
    // 2 3 4 5 6 12 13
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        
        int n = nums1.length;
        int m  = nums2.length;
        
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0;
        int high = n;
        
        
        while(low <= high) {
            
            int partX = low + (high - low) /2;
            
            int partY = (m+n)/2 - partX;
            
//             boundy elements and make partitions
            //             there are no element in first array left 
            double l1 =  (partX == 0 ) ? Integer.MIN_VALUE : nums1[partX-1];
            //             there are no element in first array right 
            double r1 =  (partX == n ) ? Integer.MAX_VALUE : nums1[partX];
            //             there are no element in second array left
            double l2 =  (partY == 0 ) ? Integer.MIN_VALUE : nums2[partY-1];
            //             there are no element in second array right
            double r2 =  (partY == m ) ? Integer.MAX_VALUE : nums2[partY];
            
            
            if(l1 <= r2 && l2 <= r1) {
                // found the partition
                // if even 
                if((m + n)%2  == 0 ) {
                    return (Math.max(l1,l2) + Math.min(r1,r2) )/2;
                }else{
                    // if odd
                    return Math.min(r1, r2);
                }
            }else if ( l2 > r1) {
                //  increase left partition                     
                low = partX+1;
            }else{
                high = partX-1;
            }
            
            
        }
        
        return Double.MIN_VALUE;
        
    }
}
