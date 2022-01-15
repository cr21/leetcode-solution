/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3



*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
//         List<Integer> li = new ArrayList();
        
//         inorder(root,li, k);
        
//         return li.get(k-1);
        count = k;
        helper(root);
        return result;
    }
    
    
    private void helper(TreeNode node) {
        if(node == null) return ;
        
        // process left first
        
        helper(node.left); 
        // process root
        count--;
        
        
        if(count == 0) {
            result = node.val;
            return;
        } 
            // process right node
        
        helper(node.right);
       
        
       
        
    }
    
   
}

/*

Iterative Stack Solution : 


public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack();
        st.add(root);
        
        while(!st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            k--;
            
            if(k == 0) {
                return root.val;
            }
            root = root.right;
        }
        
        
        return -1;
        
}
*/
