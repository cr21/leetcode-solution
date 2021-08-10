/**

ou are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

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
The sum of lists[i].length won't exceed 10^4


**/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/**
O(N^2) merge two list and iteratively merge all together

**/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0 ){
            return null;
        }
        
        if(lists.length == 1  && lists[0]== null) {
            return lists[0];
        }
    
        int i =0;
        ListNode res=null;
        
        while(i < lists.length) {
            ListNode node1 = lists[i];
            i = i + 1;
            if(i < lists.length) {
                ListNode node2 = lists[i];
                ListNode merged = merge2List(node1, node2);
                res = merge2List(res, merged);
                i = i +1;
            }else{
                res = merge2List(res, node1);
            }
        }
        return res;
    }
    
    public ListNode merge2List(ListNode node1, ListNode node2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        
        while(node1 != null  && node2 != null) {
            
            if(node1.val < node2.val) {
                ListNode next = node1.next;
                dummy.next = node1;
                dummy =  dummy.next;
                node1 = next;
            }else{
                ListNode next = node2.next;
                dummy.next = node2;
                dummy = dummy.next;
                node2 = next;
            }
            
        }
        
        
        if(node1 == null) {
            dummy.next = node2;
        }
        
        if(node2 ==null) {
            dummy.next = node1;
        }
        
        
        return res.next;
    }
}
