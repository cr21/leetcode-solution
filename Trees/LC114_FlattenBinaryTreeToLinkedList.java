/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]

*/

class Solution {
    public void flatten(TreeNode root) {
        
        if(root == null || (root.left == null && root.right == null) ) {
            return ;
        }
        
        if(root.left != null) {
            
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            while(root.right !=null) {
                root = root.right;
            }
            root.right = tempRight;
            
        }
        
        flatten(root.right);
    }
    
   
}
