/**

Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105

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
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
         
        
        return merge(left, right);
    }
    
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        
        ListNode tail = dummy;
        
        while(left != null && right != null) {
            if(left.val < right.val) {
                tail.next = left;
                left = left.next;
                
            }else{
                tail.next = right;
                right = right.next;
            }
            
            tail = tail.next;
            
        }
        
        tail.next = (left != null) ? left: right;
        
        return dummy.next;
        
        
    }
    
    
    private ListNode findMid(ListNode head) {
        
        
        ListNode midPrev = null;
        
        while(head !=null && head.next !=null) {
            midPrev = (midPrev == null ) ? head : midPrev.next;
            head = head.next.next;
        }
        
        
        ListNode mid = midPrev.next;
        
        // before mid list should end it is linked list otherwise you might have Stack overflow error
        
        midPrev.next = null;
        
        
        return mid;
        
      
        
        
    }
    
   
}
