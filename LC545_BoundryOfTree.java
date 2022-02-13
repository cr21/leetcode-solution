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
    
    private boolean isLeaf(TreeNode root) {
        return root.left ==null && root.right == null;
    }
    
    private void addLeaves(List<Integer> res, TreeNode root) {
        if(isLeaf(root)) {
            res.add(root.val);
        }else{
            if(root.left !=null) {
                addLeaves(res, root.left);
            }
            if(root.right!=null){
                addLeaves(res, root.right);
            }
        }
        
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> res = new ArrayList();
        
        if(root == null) {
            return res;  
        }
        
        if(!isLeaf(root)) {
            res.add(root.val);
           
        }
        
        TreeNode t = root.left;
        // process Left
        // preorder traversal 
        while(t != null) {
            if(!isLeaf(t)) {
                res.add(t.val);
            }
            
            if(t.left != null) {
                t = t.left;
            }else{
                t= t.right;
            }
        }
        
        // process leaves
        addLeaves(res, root);
        
        // process right subtree
        
        t = root.right;
        
        // we will add in stack because we want to process in reverse order
        Stack<Integer> st = new Stack();
        
        while(t!=null) {
            
            
            if(!isLeaf(t)){
                st.add(t.val);
            }
            
            if(t.right !=null) {
                t = t.right;
            }else{
                t =t.left;
            }
        }
        
        while(!st.empty()) {
            res.add(st.pop());
        }
        
        return res;
        
        
        
    }
}
