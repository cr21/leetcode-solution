Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.StringJoiner;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",");
        String encodedString = encode(root, sj);
        System.out.println(encodedString);
        return encodedString;
        
    }

    private String encode(TreeNode node, StringJoiner sj) {
        if(node == null) {
            sj.add("X");
            return sj.toString();
        }
        // process in pre order traversal way
        // process root
        
        sj.add(String.valueOf(node.val));
        // process left subtree
        encode(node.left, sj);
        // process right subtree
        encode(node.right, sj);
        
        
        return sj.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        
        return decode(Arrays.stream(data.split(",")).iterator());
    }
    
    private TreeNode decode(Iterator<String> iter) {
        
        // process the string in preorder traversal way ( we encoded using pre order traversal so
        // decoding using pre order traversal)
        // process root first then left sub tree and then right subtree
        // get next string from iterator
        String currStr = iter.next();
        
        TreeNode curr;
        // if currentstring is not  (X or null) we will create new Tree node 
        // else we will return null
        if(!currStr.equals("X")) {
            curr = new TreeNode(Integer.parseInt(currStr));
        }else{
            return null;
        }
        
        // if current string is not null we will process left subtree first and then right subtree
        
        curr.left = decode(iter);
        curr.right = decode(iter);
        
        return curr;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));




/*
BFS VERsION



import java.util.StringJoiner;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner sj = new StringJoiner(",");
        
        if(root == null){
            return "";
        }
        
        String enc = BFS(root, sj);
        System.out.println("enc "+enc);
        return enc;
        
        
    }
    
    private String BFS(TreeNode node, StringJoiner sj) {
        
        Queue<TreeNode> q = new LinkedList();
        q.add(node);
        
        while(!q.isEmpty()) {
            
            TreeNode front = q.poll();
            
            if(front == null ){
                sj.add("X");
            }else{
                sj.add(String.valueOf(front.val));
                // process left subtree
            
                q.add(front.left);
                q.add(front.right);
            }
            
            
        }
        
        return sj.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isBlank() || data.isEmpty()) {
            return null;
        }
        Iterator<String> iter = Arrays.stream(data.split(",")).iterator();
        
        return BFS_deser(iter);
        
    }
    
    private TreeNode BFS_deser(Iterator<String> iter) {
        
        String currStr = iter.next();
        TreeNode node = new TreeNode(Integer.parseInt(currStr));
        Queue<TreeNode> q = new LinkedList();
        q.add(node);
        
        while (iter.hasNext()  && !q.isEmpty()) {
            TreeNode front = q.poll();
            // process left
            if(iter.hasNext() ) {
                
                String next_str = iter.next();
                if(!next_str.equals("X")) {
                    front.left = new TreeNode(Integer.parseInt(next_str));
                    q.add(front.left);
                }
                
            }
            // process right 
            if(iter.hasNext()) {
                String next_str = iter.next();
                if(!next_str.equals("X")) {
                    front.right = new TreeNode(Integer.parseInt(next_str));
                    q.add(front.right);
                }
                
                
            }
            
            
        }
        return node;
        
        
    }
}
*/



