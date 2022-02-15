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





// JAVA solution




class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return 0;
        
        if(intervals.length == 1) return 1;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0] ) ;
        // ((A,B) -> A-B);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        int count=0;
        
        pq.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++) {
            int [] cur= intervals[i];
            
            int cur_st = cur[0];
            int cur_end = cur[1];
            
            Integer top_e = pq.peek();
            
            if(top_e<=cur_st) {
                pq.poll();  
            }
            pq.add(cur_end); 
            
            
        }
        return pq.size();
        
    }
    
    
    public int minMeetingRoomsBruteForce(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0) return 0;
        
        if(intervals.length == 1) return 1;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0] ) ;
        // ((A,B) -> A-B);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        int count =1;
        Queue<int[]> q = new LinkedList();
        q.add(intervals[0]);
        for(int i=1;i< intervals.length;i++) {
            int [] cur_interval = intervals[i];
            boolean flag = false;
            int[] removed = new int[2];
            for(int []prev:q) {
                if(prev[1] <= cur_interval[0]) {
                    // we can use this
                    flag = true;
                    removed = prev;
                }
            }
            
            if(!flag){
                count++; 
            }else{
                q.remove(removed); 
            }
            q.add(cur_interval);
            
        }
        return count;
        
    }
}




















