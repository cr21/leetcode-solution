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


/*

More elegant solution, thanks to leetcode premium solution : 


Sort both slots1 and slots2 by the start time.
Initialize two pointers, pointer1 and pointer2, pointing to the beginning of slots1 and the beginning of slots2 respectively.
Iterate until pointer1 reaches the end of slots1 or pointer2 reaches the end of slots2:
Find the common slot of slots1[pointer1] and slots2[pointer2].
If the common slot is greater than or equal to duration, return the result.
Else, find the slot that ends earlier and move the pointer.
If no common slot is found, return an empty array.




class Solution {
public:
    vector<int> minAvailableDuration(vector<vector<int>>& slots1, vector<vector<int>>& slots2, int duration) {
        
        std::sort(slots1.begin(), slots1.end());
        
        std::sort(slots2.begin(), slots2.end());
        
        
        int first = 0;
        int second = 0;
        
        while(first < slots1.size() && second < slots2.size()) {
            
            int leftIntersect = std::max(slots1[first][0], slots2[second][0]);
            int rightIntersect = std::min(slots1[first][1], slots2[second][1]);
            
            if(rightIntersect - leftIntersect >= duration) {
                
                return vector<int> { leftIntersect, leftIntersect+duration};
            }
            if(slots1[first][1] > slots2[second][1]) {
                second++;
            }else{
                first++;
            }
             
        }
        
        vector<int> res;
        return res;
    }
};

*/



/**

2nd solution Heap Based Solution

/*
Algorithm

Initialize a heap timeslots and push time slots that last longer than duration into it.
Iterate until there's only one time slot remaining in timeslots:
Pop the first time slot [start1, end1] from timeslots.
Retrieve the next time slot [start2, end2], which is the current top element in timeslots.
If we find end1 >= start2 + duration, because start1 <= start2, the common slot is longer than duration and we can return it.
If we don't find the common slot that is longer than duration, return an empty array.
*/


/*

class Solution {
public:
    vector<int> minAvailableDuration(vector<vector<int>>& slots1, vector<vector<int>>& slots2, int duration) {
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        
        // push all the timeslots for person 1 which is greater or equals to duration
        for(auto vec : slots1) {
            
            if(vec[1] -vec[0] >= duration){
                pq.push(vec);
            }
        }
        
        
        
        // push all the timeslots for person 2 which is greater or equals to duration
        for(auto vec : slots2) {
            
            if(vec[1] -vec[0] >= duration){
                pq.push(vec);
            }
        }
        
        
        
        while(pq.size() > 1)  {
            
            auto first = pq.top();
            pq.pop();
            auto second = pq.top();
            
            // if first contains second and second start +duration < first end that means we got an answer
            if(first[1] >= second[0] + duration) {
                return vector<int> {second[0], second[0]+duration};
            }
            
        }
        vector<int>  res;
        return res;
        
    }
    
};





**/
