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
        
        head.next=reverseList(head.next);
            
        ListNode tail=head.next;
            
        while(tail.next!=null)
            tail=tail.next;
            
        tail.next=new ListNode(head.val);
            
        return head.next;
        
    }
}