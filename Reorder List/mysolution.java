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
        
        if(head==null||head.next==null||head.next.next==null)
            return;
        
        ListNode curr=head;
        ListNode left=head.next;
        ListNode right=null,last=null;
        
        while(curr.next.next!=null)
        {    
            curr=curr.next;
        }
        
        right=curr;
        last=curr.next;
        
        right.next=null;
        
        reorderList(left);
        
        head.next=last;
        last.next=left;
        
    }
}