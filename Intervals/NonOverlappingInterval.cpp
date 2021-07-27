/*


Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-2 * 104 <= starti < endi <= 2 * 104

*/


class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        std::sort(intervals.begin(), intervals.end());
        
        
        if(intervals.size() <= 1) return 0;
        
        vector<int> prev = intervals[0];
        int count = 0;
        
        for(int i=1; i < intervals.size(); i++) {
            
            vector<int> curr = intervals[i];
            
            // No overlap
            
            // No Over lap case
            if(curr[0] >=prev[1]) {
                prev =curr;
                
                
            }
            // intervals are sorted based on start time and then end time so if the start time of prev interval
            // is greater or equals to current interval start time then we will remove largetst interval aka
            // later interval because intervals are sorted we don't change prev 
            else if( prev[0] >= curr[0]  ) {
                count++;
                
            }
            // if current interval overlaps the prev interval and current interval is larger remove larger interval
            else if(prev[0] <= curr[0] && prev[1] >= curr[0] && curr[1] >= prev[1]) {
                count++;
            }
            // in any other case we change previous and update the count
            else {
                
                prev =curr;
                count++;    
            }
            
            
        }
        
        
        return count;
        
        
    }
};
