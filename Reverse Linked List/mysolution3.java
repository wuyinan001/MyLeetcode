/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null)
            return null;
        
        if(head.next==null)
            return head;
        
        // This node will be tail node of reverseList(head.next)
        ListNode temp=head.next;
        
        ListNode newhead=reverseList(head.next);

            
        temp.next=head;
        head.next=null;
            
        return newhead;
        
    }
}