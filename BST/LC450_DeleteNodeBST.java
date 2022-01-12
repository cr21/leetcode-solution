/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.


*/

class Solution {
    
    public int successor(TreeNode root) {
        
        root = root.right;
            
        while (root.left != null) {
            root= root.left;
            
        }
        
        return root.val;
    }
    
    public int predecessor(TreeNode root) {
        
        
        root= root.left;
        
        while(root.right !=null) {
            root = root.right;
        }
        
        return root.val;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        
        else if(root.val < key ){
            root.right = deleteNode(root.right, key);
        }
        
        // we find the node here delete it
        else {
            // if node to delete is leaf node then set root = null
            
            if(root.left == null && root.right == null) {
                root = null;
            }
            // if root is not leaf node and right subtree is not null
            else if(root.right !=null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        
        return root;
        
        
        
        
    }
}
