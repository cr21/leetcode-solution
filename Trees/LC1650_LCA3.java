/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};

Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q exist in the tree.
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        // if p is root p is the answer
        if(p.parent == null) return p;
        // if q is root q is the answer
        if(q.parent == null) return q;
        // find the root
        Node root = findRoot(p);
        // find the lca
        return LCA(root, p,q);
        
    }
    
    public Node LCA(Node root, Node p, Node q) {
        if(root == null) {
            return null;
        }
        
        // if we find any of the val then return root
        
        if(root.val == p.val || root.val == q.val) {
            return root;
        }
        
        // if we did not find anything
        // we will run lca on left or right child
        Node left_lca = LCA(root.left, p,q);
        Node right_lca = LCA(root.right, p,q);
        
        
        // if left and right lca is not null then root is the lca
        if(left_lca != null && right_lca != null) {
            return root;
        }
        
        // if left lca is not null then lca is in left branch
        if(left_lca != null) {
            return left_lca;
        }
        // else it is in right branch
        if(right_lca != null) {
            return right_lca;
        }
        
        return null;
        
        
    }
    
    private Node findRoot(Node p){
        Node curr = p;
        Node prev = null;
        while(curr !=null) {
            // when current goes outof bound prev will point to root
            prev = curr;
            curr = curr.parent;     
        }
        
        return prev;
        
    }
}
