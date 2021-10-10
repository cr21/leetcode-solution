/*
https://leetcode.com/problems/lfu-cache/
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, 3, null, -1, 3, 4]

Explanation
// cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
LFUCache lfu = new LFUCache(2);
lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
lfu.get(1);      // return 1
                 // cache=[1,2], cnt(2)=1, cnt(1)=2
lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
lfu.get(2);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,1], cnt(3)=2, cnt(1)=2
lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                 // cache=[4,3], cnt(4)=1, cnt(3)=2
lfu.get(1);      // return -1 (not found)
lfu.get(3);      // return 3
                 // cache=[3,4], cnt(4)=1, cnt(3)=3
lfu.get(4);      // return 4
                 // cache=[3,4], cnt(4)=2, cnt(3)=3
 

Constraints:

0 <= capacity <= 104
0 <= key <= 105
0 <= value <= 109
At most 2 * 105 calls will be made to get and put.
*/

class LFUCache {
    
    class Node {
        
        int key;
        int data;
        int freq;
        Node prev;
        Node next;
        
        Node() {
            key = -1;
            data = -1;
            freq = 1;
            prev = null;
            next = null;
            
        }
        
        
        Node(int key, int data) {
            this.key = key;
            this.data = data;
            this.freq = 1;
            prev = null;
            next = null;
        }
        
        
    }
    
    public class DLL {
        
        Node head;
        Node tail;
        int size;
        
        public DLL() {
            head = new Node();
            tail = new Node();
            size = 0;
            head.next = tail;
            tail.prev = head;
        }
        
        
        
       public void addToHead(Node node) {
            
            Node headNext = head.next;
            
            head.next = node;
            node.prev = head;
            node.next = headNext;
            headNext.prev = node;
            size+=1;
        }
        
       public void remove(Node node) {

            Node before = node.prev;
            Node after = node.next;
            
            after.prev = before;
            before.next = after;
            
            size-=1;
        }
        
        
      public  Node removeLast() {
            Node node = tail.prev; 
            remove(node);
            return node;  
        }
    }
    
    int minFreq;
    int capacity;
    int size;


    HashMap<Integer, Node> cache;
    HashMap<Integer, DLL> counterMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        cache= new HashMap();
        counterMap = new HashMap();
        
    }
    
    
    private void update(Node node) {
        
        int count = node.freq;
        
        DLL oldDLL = counterMap.get(count);
        oldDLL.remove(node);
        
        if(count == minFreq && oldDLL.size == 0) {
            minFreq+=1;
        }
        
        int newCount = count+1;
        node.freq = newCount;
        
        counterMap.putIfAbsent(newCount, new DLL());
        counterMap.get(newCount).addToHead(node);
        
    }
    
    
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }else{
            Node node = cache.get(key);
            update(node);
            return node.data;     
        }
    }
    
    public void put(int key, int value) {
        
            if(cache.containsKey(key)) {
                Node node = cache.get(key);
                node.data = value;
                update(node);
                return;
            }else{
                if(capacity == 0) {
                    return;

                }
                else if (cache.size() == capacity) {
                    Node node = counterMap.get(minFreq).removeLast();
                    cache.remove(node.key);

                }

                Node newNode = new Node(key, value);
                minFreq = 1;
                
                cache.put(key, newNode);
                counterMap.putIfAbsent(minFreq, new DLL());
                counterMap.get(minFreq).addToHead(newNode);

            }
            
            
            
        }
        
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
