/*

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]

*/

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        deque<vector<int>> result;
        
        vector<vector<int>> res;
        if(root == nullptr) {
            return res;
        }
        
        queue<TreeNode *> q;
        
        q.push(root);
        
        while(!q.empty()) {
            int size = q.size();
            
            vector<int> levels;
            while(size-->0) {
                
                TreeNode *f = q.front();
                levels.push_back(f->val);
                q.pop();
                
                if(f->left !=  nullptr) q.push(f->left);
                if(f->right != nullptr) q.push(f->right);
                
            }
            
            result.push_front(levels);
            
            
        }
        
        
        vector<vector<int>> fi (result.begin(), result.end());
        return fi;
    }
};
