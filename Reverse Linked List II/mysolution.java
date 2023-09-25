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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        
        if(m==n)
            return head;
        
        ListNode prev=null,prestart=null,start=null,end=null;
        ListNode curr=head;
        ListNode temp=null;
        
        for(int i=1;i<=m;i++)
        {
            if(i==m-1)
                prestart=curr;
            
            if(i==m)
            {
                prev=curr;
                start=curr;
            }
                
            curr=curr.next;
        }
        
        for(int i=1;i<=n-m;i++)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        
        end=prev;
        
        if(prestart==null)
        {
            start.next=curr;
            return end;
        }
        
        prestart.next=end;
        start.next=curr;
        
        return head;
        
    }
}