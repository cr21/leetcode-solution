/*

A set of real numbers can be represented as the union of several disjoint intervals, where each interval is in the form [a, b). A real number x is in the set if one of its intervals [a, b) contains x (i.e. a <= x < b).

You are given a sorted list of disjoint intervals intervals representing a set of real numbers as described above, where intervals[i] = [ai, bi] represents the interval [ai, bi). You are also given another interval toBeRemoved.

Return the set of real numbers with the interval toBeRemoved removed from intervals. In other words, return the set of real numbers such that every x in the set is in intervals but not in toBeRemoved. Your answer should be a sorted list of disjoint intervals as described above.

 

Example 1:


Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
Output: [[0,1],[6,7]]
Example 2:


Input: intervals = [[0,5]], toBeRemoved = [2,3]
Output: [[0,2],[3,5]]
Example 3:

Input: intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
Output: [[-5,-4],[-3,-2],[4,5],[8,9]]
 

Constraints:

1 <= intervals.length <= 104
-109 <= ai < bi <= 109

*/


class Solution {
public:
    vector<vector<int>> removeInterval(vector<vector<int>>& intervals, vector<int>& toBeRemoved) {
        
        vector<vector<int>> res;
        /*
            Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
            Output: [[0,1],[6,7]]
            
            Input: intervals = [[0,5]], toBeRemoved = [2,3]
            Output: [[0,2],[3,5]]
        */
        for(int i =0; i< intervals.size();i++) {
            
            
            // there are three case
            
            // 1) no overlap 
            if(intervals[i][1] < toBeRemoved[0] || intervals[i][0] > toBeRemoved[1]) {
                
                res.push_back(vector<int> {intervals[i][0], intervals[i][1]});
            }else{
                // 2) right overlap (left to keep)
                if(intervals[i][0] < toBeRemoved[0]) {
                    res.push_back(vector<int> {intervals[i][0], toBeRemoved[0]});
                }
                
                // 3)  left overlap (right to keep)
                
                if(intervals[i][1] > toBeRemoved[1]) {
                    res.push_back(vector<int> {toBeRemoved[1], intervals[i][1]});
                }
            
            }
            
                
        }
        
        return res;
        
    }
};
