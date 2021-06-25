/**

You are given an integer n, which indicates that there are n courses labeled from 1 to n. You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.

Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.


**/


class Solution {
public:
    int minimumSemesters(int n, vector<vector<int>>& relations) {
        
        // build the graph 
        
        vector<int> indegree (n+1, 0);
        vector<vector<int>> graph(n+1);
        
        // Build graph
        for (auto temp : relations) {
            graph[temp[0]].push_back(temp[1]);
            indegree[temp[1]]++;
        }
        
       
        // if no cycle is detected then find the longest path to get the value of number of semester required
        
        
        // unvisited 
        vector<int> visitedLength (n+1,0);
        
        
        int maxLength = 1;
        for(int node = 1; node < n+1; node++) {
            
            int length = dfs(node,  graph, visitedLength) ;
            
            // if length == -1 then from that node we have cycle so not possible
            if(length == -1) {
                return -1;
            }
            
            maxLength = max(maxLength, length) ;
            
        }
        
        return maxLength;
            
    }
    
     
    
    
    int dfs(int node, vector<vector<int>>& graph, vector<int>& visited) {
        // if visiting return -1
        
        if(visited[node] != 0) {
            return visited[node];
        } else{
            // set visiting
            visited[node] =-1;
        }
        
        int maxLength = 1;
        
        for(auto & endNode: graph[node] ) {
            
            int length = dfs(endNode,  graph, visited);
            
            if(length == -1) {
                return -1;
            }
            
            maxLength = max(maxLength, length +1);
            
        }
        
        // mark visited
        
        visited[node] = maxLength;
        
        return maxLength;
        
        
    }
    
};
