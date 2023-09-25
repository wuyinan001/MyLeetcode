/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) 
    {
        if(head==null)
            return null;
        
        if(head.next==null)
            return head;
        
        head.next=partition(head.next,x);

        if(head.val>=x&&head.next.val<x)
        {
            ListNode temp=head.next;
            
            while(temp.next!=null)
            {
                if(temp.next.val>=x)
                    break;
                
                temp=temp.next;
            }
            
            ListNode nexthead=head.next;
            head.next=temp.next;
            temp.next=head;
            head=nexthead;
        }
        
        return head;
    }
}