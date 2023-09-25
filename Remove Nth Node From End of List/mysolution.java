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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast=head;
        ListNode prehead=new ListNode();
        prehead.next=head;
        ListNode slow=prehead;
        
        int count=0;
        
        while(fast.next!=null)
        {
            if(count<n-1)
                fast=fast.next;
            else
            {
                fast=fast.next;
                slow=slow.next;
            }
            
            count++;
        }
        
        slow.next=slow.next.next;
        
        return prehead.next;
    }
}