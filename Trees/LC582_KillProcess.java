
You have n processes forming a rooted tree structure. You are given two integer arrays pid and ppid, where pid[i] is the ID of the ith process and ppid[i] is the ID of the ith process's parent process.

Each process has only one parent process but may have multiple children processes. Only one process has ppid[i] = 0, which means this process has no parent process (the root of the tree).

When a process is killed, all of its children processes will also be killed.

Given an integer kill representing the ID of a process you want to kill, return a list of the IDs of the processes that will be killed. You may return the answer in any order.

/* Tree Simulation algorithm

*/
  
  class Solution {
    
    public class Node{
        
        int value;
        List<Node> children;
        
        public Node() {
            
        }
        public Node(int value) {
            this.value = value;
            this.children = new ArrayList();
        }
       
    }
    
    private Node buildTree(List<Integer> pid, List<Integer> ppid) {
        Node root=null;
        
        for( int i=0 ; i< pid.size(); i++) {
            int _pid = pid.get(i);
            Node n;
            if(!map.containsKey(_pid)) {
                n = new Node(_pid);
                map.put(_pid, n);
            }
        }
        
        
         for( int i=0 ; i< ppid.size(); i++) {
            int _ppid = ppid.get(i);
            Node n;
            if(!map.containsKey(_ppid)) {
                n = new Node(_ppid);
                map.put(_ppid, n);
            }
        }
        
        
        
        for(int i=0; i< ppid.size();i++) {
            int parentId = ppid.get(i);
            int childId = pid.get(i);
            // setting root
            if(parentId == 0) {
                root = map.get(childId);
            }else{
                Node parentNode = map.get(parentId);
                Node childNode = map.get(childId);
                parentNode.children.add(childNode);   
            }    
        }
        
        return root;
    }
    HashMap<Integer, Node> map;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        map = new HashMap();
        
        // build Tree
        
        Node root = buildTree(pid, ppid);
        
        List<Integer> res = new ArrayList();
        Node kill_node = map.get(kill);
        if(kill_node == null) {
            return null;
        }else{
            Stack<Node> st = new Stack();
            st.push(kill_node);
            
            while(!st.isEmpty()) {
                Node popped = st.pop();    
                res.add(popped.value);
                for(Node n: popped.children) {
                    st.push(n);
                } 
            }
        }
        return res;
        
    }
}
