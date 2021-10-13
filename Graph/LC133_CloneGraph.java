/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

 

*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Node newNode = deepCopy(node);
        
        return newNode;
        
    }
    
    
    private Node deepCopy(Node node) {
        
        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }else{
            Node  n = new Node(node.val, new ArrayList<Node>());
            visited.putIfAbsent(n.val, n);
            for(Node _node : node.neighbors){
                n.neighbors.add(deepCopy(_node));
            } 
            
            return n;
        }
       
        
        
        
        
        
        
    }
}
