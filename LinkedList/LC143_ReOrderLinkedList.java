You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
  
  
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
   
    public void reorderList(ListNode head) {
        if(head == null) return ;
        
        ListNode middle =  findMiddle(head);
        ListNode second = ReverseList(middle);
        // middle.next = null;
        ListNode first = head;
        ListNode temp;
        
        // move first and second alternatively
        while(second.next !=null) {
            temp  = first.next;
            first.next = second;
            first = temp;
            
            temp = second.next;
            second.next = first;
            second = temp;
        }
        
        
    }
    
    // reverse list after middleNode
    private ListNode ReverseList(ListNode node) {
        
        ListNode cur = node;
        ListNode prev = null;
        ListNode next = cur;
        while(cur.next!=null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next; 
        }
        cur.next = prev;
        
        return cur;
    }
    
    /*
    Find middle of the linkedlist
    */
    private ListNode findMiddle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        
        while(fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
