
/*
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res(nums.size(), -1);

        int index = 0;
        int n = nums.size();
        for(int i = 0; i < n ;i++) {
            
            for(int j = i+1; j < 2*n ;j++) {
                
                if(nums[j%n] > nums[i]) {
                    res[i] = nums[j%n];
                    break;
                }
            }
            
        }
        
        return res;
    }
};

*/


class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res(nums.size(), -1);
        
//        [1,2,3,4,3]
        int index = 0;
        int n = nums.size();
        stack<int> st;
      
        for(int i = 2*n-1;i >= 0;i--) {
            
            while(!st.empty() && st.top() <= nums[i%n] ) {
                st.pop();
            }
            
            if(!st.empty()) {
                res[i%n] = st.top();
            }    
            
            st.push(nums[i%n]);
            
            
        }
        
        return res;
    }
};

// 
