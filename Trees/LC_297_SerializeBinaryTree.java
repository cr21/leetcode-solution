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
