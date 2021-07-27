/*

Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106

*/

class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
        
        if (intervals.empty()){
            return true;
        }
        // if overlapp then not possible
        
        std::sort(intervals.begin(), intervals.end(), [] (vector<int> first , vector<int> second)  {
            return first[0] < second[0];
        } );
        
        vector<int> prev = intervals[0];
        for(int i =1; i< intervals.size();i++) {
            vector<int> curr = intervals[i];
            // overlapped
            if(prev[1] > curr[0]) {
                // need to merge
                return false; 
            }
             prev = curr;
         }
        
        return true;
        
        
    }
};
