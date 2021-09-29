/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


*/


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
       vector<deque<int>> result;
        
        vector<vector<int>> res;
        if(root == nullptr) {
            return res;
        }
        
        queue<TreeNode *> q;
        
        q.push(root);
        
        while(!q.empty()) {
            int size = q.size();
            
            deque<int> levels;
            while(size-->0) {
                
                TreeNode *f = q.front();
                if(result.size() % 2==0) {
                    levels.push_back(f->val);
                }else{
                    levels.push_front(f->val);
                }
                
                q.pop();
                
                if(f->left !=  nullptr) q.push(f->left);
                if(f->right != nullptr) q.push(f->right);
                
            }
            
            
            result.push_back(levels);
            
            
        }
        
        
        vector<vector<int>> fi ;
        
        for(int i=0;i<result.size(); i++) {
            deque<int> l = result.at(i);
            vector<int> vi(l.begin(), l.end());
            fi.push_back(vi);
            
        }
        return fi;
    }
};
