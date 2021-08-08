/**


https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2


**/


// 1) solution Binary search 

class Solution {
public:
    
    // function to find the total number of element less than mid element
    int countLessThanMid(const int &mid, const vector<vector<int>> &matrix) {
        int count = 0;
        int row = 0;
        
        int n = matrix.size();
        int col = n-1;
        while(row < n && col >=0){
                
            // if current element is less than or equals to mid then entire element less than current column
            // are less or equals to mid and then we start checking next row in same column
            // else decrease the col to check in previous col in current row
            if(matrix[row][col] <= mid) {
                row++;
                count += col+1;
            }else{
                col--;
            }
                
        }
      
        
        //std::cout << " count " <<count;
        return count;
        
        
    }
    
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        
        int l = matrix[0][0];
        int n = matrix.size();
        int r = matrix[n-1][n-1];
        
        while(l < r) {
            
            int mid =(r+l)/2;
            
            // count the number of element less than mid 
            //std::cout <<  " mid " << mid <<std::endl;
            int count = countLessThanMid(mid, matrix);
            //std::cout << "count " << count <<std::endl;
            
            if(count < k ) {
                l = mid+1;
            }else{
                r = mid;
            }   
            
        }
        
        return r;
        
        
    }
    
    
   
};


// 1.1) Modified Improved Binary search with cpp algorithm function

// CREDIT :  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1383596/20-MS-or-C%2B%2B-or-Binary-Search-or-Monotonic-Predicate-Function-or-O(N*Log(N)*Log(Max(Matrix)))


/*
struct Solution {

    int kthSmallest(vector<vector<int>>& m, int k) {
        
        const int n = m.size();
        
        int l = m[0][0], r = m[n-1][n-1];
        
        auto count = [&m, &k] (int e, int cnt = 0) -> bool {
            for (auto &x : m) {
                cnt += upper_bound(x.begin(), x.end(), e) - x.begin();
                if (cnt >= k) return true;
            } return false;
        };
        
        while (l < r) {
            int e = l + ((r - l) >> 1);
            count(e) ? (r = e) : (l = e + 1);
        }
        
        return r;
    }
};

*/


// 2) Heap Solution


class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
       priority_queue<int, vector<int>> pq;
        
        for(auto vec : matrix) {
            
            for (auto ele: vec) {
                //std::cout << "__" <<ele << " ";
                
                pq.push(ele);
                if(pq.size() > k) {
                    pq.pop();
                }
                
            }
        } 
        
        // while(!pq.empty()) {
        //     std::cout << pq.top() << endl;
        //     pq.pop();
        // }
    
        
        return pq.top();
    }
};

