/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

*/

// 1st approach Min max limit

class Solution {
    
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
        
        
    }
    
    private boolean dfs(TreeNode root, Integer min, Integer max) {
        if(root == null) {
            return true;
        }
        
        // System.out.println( ! ( root.val >= min && root.val <= max));
        if(min != null  &&  ! (root.val > min)) {
            return false;
        }
          
        if(max != null  &&  ! (root.val < max)) {
            return false;
        }
           
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
        
        
    }
}

/*

Solution 2: Recursive Inorder Traversal

*/

class Solution {
    TreeNode prevNode;
    public boolean isValidBST(TreeNode root) {
         
        return inorder(root);
        
        
    }
    
    private boolean inorder(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if  (!inorder(root.left)) return false;
        
        if(prevNode != null && !(prevNode.val < root.val))  {
            return false;
        }
        
        prevNode = root;
        
        return inorder(root.right);
           
    }
}

// solution iterative Inorder traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        
        if(root == null ) return true;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode prevNode = null;
        while (root != null || !st.isEmpty()) {
            
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            
            root = st.pop();
            
            if(prevNode != null && root.val <= prevNode.val    ) {
                return false;
            }
            prevNode = root;
            
            root = root.right;
        
            
        }
        
        
        
        return true;
    }
}
