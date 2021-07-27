/**


Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

**/


    
class Solution {
public:
    
    
    int minMeetingRooms(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end());
        
        priority_queue<int, vector<int>, greater<int>> pq;
        
       
        for(auto pair: intervals) {
            
            if(pq.size() > 0 &&  pq.top() <= pair[0]) {
                pq.pop();
               
            }
            
            pq.push(pair[1]);
            
        }
        
        
        return pq.size();
        
        
        
        
    }
};




























