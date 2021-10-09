/*

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.
*/

class LRUCache {

    int capacity ;
    class Node {
        int key;
        int val;
        Node next = null;
        Node prev = null ;
        
        Node() {
            
        }
          
        Node(int k,int d ){
            this.key = k;
            this.val = d;
        }
        
        
    }
    
    Map<Integer, Node> map ;
    
    Node head;
    Node tail;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap();
        size=0;
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    // this function will add node n1 to tail 
    private void add(Node n1) {
        Node temp = tail.prev;
        temp.next = n1;
        n1.next = tail;
        tail.prev = n1;
        n1.prev = temp;  
    }
    
    
    // remove node n1;
    private void remove(Node n1) {
        Node before = n1.prev;
        Node after = n1.next;   
        before.next = after;
        after.prev = before;
        
    }
    
    
    private void update(Node n1) {
        remove(n1);
        add(n1);
    } 
    
    
    public int get(int key) {
        Node curr = map.get(key);
        if(curr == null) {   
            return -1;
        }
        update(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
//          check if key exists or not
        
        Node curr = map.get(key);
        // if curr is not in map
        if(curr == null) {
            
            curr = new Node(key, value);
            map.put(key, curr);
            size+=1;
            add(curr);
        }else{ 
            update(curr);
            curr.val = value;
        }
        
        if(size > capacity) {
//              remove from head evict least recently used key
            size-=1;
            map.remove(head.next.key);       
            remove(head.next);     
        }   
    }
    
} 
    

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
