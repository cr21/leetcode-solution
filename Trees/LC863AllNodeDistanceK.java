
/*Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
  */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k1) {
        parentMap = new HashMap();
        
        dfs(root, null);
        
        Queue<TreeNode> q = new LinkedList();
        
        int currentLayer = 0;
        q.add(target);
        Set<TreeNode> visited = new HashSet();
        while(!q.isEmpty() && currentLayer < k1) {
            
            int size = q.size();
            
            
            // process layer
            for(int i=0;i<size;i++) {
                TreeNode popped = q.poll();
                if(!visited.contains(popped)) {
                   visited.add(popped);
                    // add left child
                    if(popped.left != null && !visited.contains(popped.left)  ){
                        q.add(popped.left);
                    }
                    // add right child
                    if(popped.right != null && !visited.contains(popped.right) ){
                        q.add(popped.right);
                    }
                    // add parent
                    if(parentMap.get(popped)!=null && !visited.contains(parentMap.get(popped))) {
                        q.add(parentMap.get(popped));
                    } 
                }  
            }
            currentLayer++;     
        }
        
        List<Integer> res = new ArrayList();
        
        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }
        
        return res;
        
        
    }
    
    private void dfs(TreeNode root, TreeNode parent) {
        if(root == null) return;
        parentMap.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
        
    }
    
    
}
