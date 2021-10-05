/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

*/


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode combined = new ListNode(-1);
        
        ListNode res = combined;
        
        if(lists.length == 0 ){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for(ListNode n : lists) {
            if(n != null ) {
                pq.add(n);    
            }
            
        }
        
        while(!pq.isEmpty()) {
            
            
            ListNode node  = pq.poll();
            res.next = node;
            res = res.next;
            if(node.next != null) {
                pq.add(node.next);
            }
        }
        
        return combined.next;
        
    }
}
