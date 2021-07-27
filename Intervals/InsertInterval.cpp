/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 105
intervals is sorted by intervals[i][0] in ascending order.
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 105

*/


class Solution {
    
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        if(intervals.empty() || intervals.size() == 1) return intervals;
        
        // sort the interval based on start time
        std::sort(
                intervals.begin(), intervals.end(), 
                [](vector<int> first, vector<int> second) { return (first[0] < second[0]);  } 
        );
        
        
        // return intervals;
        vector<vector<int>> res;
        
        res.push_back(intervals[0]);
        
        int outputIndex = 0;
        
        vector<int> prev = res[0];
        
        for(int i =1; i< intervals.size();i++) {
            vector<int> curr = intervals[i];
            
            // check if need to merge
            if(prev[1] >= curr[0]) {
                // need to merge
                
                res[outputIndex][1] = std::max(curr[1], prev[1]); 
                
            }else{
                res.push_back(curr);
                outputIndex++;
            }
            
            prev = res[outputIndex];
           
         
        }
        
        
        return res;
    }
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        intervals.push_back(newInterval);
        intervals = merge(intervals);
        return intervals;
        
    }
};



