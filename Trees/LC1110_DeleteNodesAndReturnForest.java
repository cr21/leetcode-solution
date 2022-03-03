Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest. You may return the result in any order.


  
  
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
    List<TreeNode> res = new ArrayList();
    HashSet<Integer> set = new HashSet();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return res;
        for(int i=0;i<to_delete.length;i++) {
            set.add(to_delete[i]);
        }
        dfs(root);
        
        
        if(!set.contains(root.val)){
            res.add(root);
        }
        
        return res;
        
    }
    
    private TreeNode dfs(TreeNode root) {
        if(root == null) return null;
        
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        
        if(set.contains(root.val) ) {
            if(root.left !=null){
                res.add(root.left);
            } 
            if(root.right !=null){
               res.add(root.right);  
            } 
            // if you ever find the items to be deleted you want to set it as null to it;s parent
            // before retruning null just add it's childrent to forest list
            return null;
        }
        
        return root;
        
    }
}
  
