/*
Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []

*/

/*
Dirty solution O(N) lots of if else loop to cover no overlap, left and right overlap and entire overlap case

*/

class Solution {
public:
    vector<int> minAvailableDuration(vector<vector<int>>& slots1, vector<vector<int>>& slots2, int duration) {
        
        std::sort(slots1.begin(), slots1.end());
        
        std::sort(slots2.begin(), slots2.end());
        
        
        int first = 0;
        int second = 0;
        
        while(first < slots1.size() && second < slots2.size()) {
            int duration1 = slots1[first][1] - slots1[first][0];
            int duration2 = slots2[second][1] - slots2[second][0] ;
            // Case 1 : if length of slot is less then duration you can not hold meeting move ahead
            
            // if no overlap
            if( slots1[first][1] <= slots2[second][0] || slots2[second][1] <= slots1[first][0]) {
                
                if(slots1[first][1] <= slots2[second][1]) {
                    first++;
                }else{
                    second++;
                }
                
            } else{
                
                // entire overlap first inside second
                
                if( slots1[first][0] >= slots2[second][0] && slots1[first][1] <= slots2[second][1]) {
                    if(duration1 >= duration) {    
                        return vector<int> {slots1[first][0], slots1[first][0]+duration};
                    }else{
                        first++;     
                    }
                        
                }
                // entire overlap second inside first
                else if( slots2[second][0] >= slots1[first][0]  && slots2[second][1] <= slots1[first][1]) {
                    if(duration2 >= duration) {
                        return vector<int> { slots2[second][0], slots2[second][0]+duration};
                    }else{
                        second++;
                    }
                }
                // right over lap case1
                else if( slots1[first][0] <= slots2[second][0]  )  {
                   
                    int overlap = slots1[first][1] - slots2[second][0];
                    if(overlap >= duration) {
                        return vector<int> { slots2[second][0], slots2[second][0]+duration};
            
                    }else{
                        first++;
                    }
                    // right overlap case 2
                }else  if( slots2[second][0] <= slots1[first][0] )  {
                   
                    
                    int overlap = slots2[second][1] - slots1[first][0];
                    if(overlap >= duration) {
                        return vector<int> { slots1[first][0], slots1[first][0]+duration};
            
                    }else{
                        second++;
                    }
                }
                
                // left overlap case 1
                else if(slots2[second][0] <=   slots1[first][1]  ) {
                   
                  int overlap = slots1[first][1] - slots2[second][0];
                    
                    if(overlap >= duration) {
                        return vector<int> {slots2[second][0], slots2[second][0]+duration};
                    }else{
                        first++;
                    }
                          
                }
                //left overlap case 2
                else if(slots1[first][0] <= slots2[second][1] ) {
                   
                  int overlap = slots2[second][1] - slots1[first][0];
                    
                    if(overlap >= duration) {
                        return vector<int> {slots1[first][0], slots1[first][0]+duration};
                    }else{
                        second++;
                    }
                          
                }
                
            }
            
             
        }
        
        vector<int> res;
        return res;
    }
};
