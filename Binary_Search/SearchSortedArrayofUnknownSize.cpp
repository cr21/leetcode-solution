/**

This is an interactive problem.

You have a sorted array of unique elements and an unknown size. You do not have an access to the array but you can use the ArrayReader interface to access it. You can call ArrayReader.get(i) that:

returns the value at the ith index (0-indexed) of the secret array (i.e., secret[i]), or
returns 231 - 1 if the i is out of the boundary of the array.
You are also given an integer target.

Return the index k of the hidden array where secret[k] == target or return -1 otherwise.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: secret = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in secret and its index is 4.
Example 2:

Input: secret = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in secret so return -1.


**/

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */


/**


Find the index where value is greater than target and then run binary search

**/
class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        
        int index = 0;
        // INT_MAX
        
        if(reader.get(index) == target ) return 0;
        if(reader.get(index)== INT_MAX) return -1;
        
        index =1;
        
        if(reader.get(index) == target ) return 1;
        if(reader.get(index)  == INT_MAX) return -1;
        
        while(reader.get(index) < target && reader.get(index)!= INT_MAX) {
            index=  2*index;
            
        }
        
        
        
        int left = 0;
        
        int right = index;
        
        
        while(left <= right) {
            
            int midIdx = left + (right-left)/2;
            int midEle = reader.get(midIdx);
            if(midEle == target) {
                return midIdx;
            }else if(midEle < target) {
                left = midIdx+1;
            }else{
               right = midIdx-1;    
            }
            
        }
        return -1;
    
        
        
    }
};
