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
        
        // if root is null or both of it;s children are null return
        if(root == null || (root.left == null && root.right == null) ) {
            return ;
        }
        
        // if left subtree of current node is not null proceed with flattening left  subtree 
        // after flattening left subtree
        // set current node right = node left 
        // set node left to null
        // maintain temp variable to hold node's right before updating right pointer
        // 
        if(root.left != null) {
            
            flatten(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            // iterate over the right most subtree
            // when we will find node at most right subtree
            // this node points to flattening of right subtree
            
            while(root.right !=null) {
                root = root.right;
            }
            // set current right most node next node to temp right node we store it earlier
            root.right = tempRight;
            
        }
        
        // flatten right subtree
        flatten(root.right);
    }
    
   
}

/*
STACK Iterative Solution



*/

class Pair<K,V> {
    
    K key;
    V value;
    
    Pair(K a, V b) {
        this.key = a;
        this.value = b;
    }
    
    public K getKey(){
        return this.key;
    }
    
    public V getValue() {
        return this.value;
    }
    
    
}
class Solution {
    public void flatten(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        int START = 1, END = 2;
        
        TreeNode tailNode = null;
        Stack<Pair<TreeNode, Integer>> st = new Stack();
        st.push(new Pair<TreeNode, Integer> (root, START));
        
        while(!st.isEmpty()) {
            
            Pair<TreeNode, Integer> popped = st.pop();
            
            TreeNode currentNode = popped.getKey();
            Integer recursionState = popped.getValue();
            
            // if leaf node
            
            if(currentNode.left == null && currentNode.right == null) {
                tailNode = currentNode;
                continue;
            }
            
            // if node recursion state is start that means it has not yet processed its left
            // sub tree
            if(recursionState == START) {
                
                if(currentNode.left != null) {
                    
                    st.push(new Pair<TreeNode, Integer> (currentNode,END ));
                    st.push(new Pair<TreeNode, Integer> (currentNode.left,START));
                    
                    
                }else if(currentNode.right != null) {
                    
                    st.push(new Pair<TreeNode,Integer> (currentNode.right, START));
                }
                
            }else{
                
                // if currentNode is in END recursion STATE
                
                TreeNode rightNode = currentNode.right;
                
                if(tailNode!= null) {
                    tailNode.right = currentNode.right;
                    currentNode.right = currentNode.left;
                    currentNode.left = null;
                    rightNode = tailNode.right;
                     
                }
                
                if(rightNode != null) {
                    st.push(new Pair<TreeNode, Integer> (rightNode, START));
                }
            }
            
        }
        
        
    }
    
    
}
