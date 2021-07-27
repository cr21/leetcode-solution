/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104




*/


class Solution {
    

public:
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
};
