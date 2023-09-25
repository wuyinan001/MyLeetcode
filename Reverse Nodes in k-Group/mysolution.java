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
    
    private ListNode reverse(ListNode head)
    {
        if(head==null||head.next==null)
            return head;
        
        ListNode curr=head.next;
        
        curr=reverse(curr);
        
        ListNode end=curr;
        
        while(end.next!=null)
            end=end.next;
        
        end.next=head;
        head.next=null;
        
        return curr;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head==null)
            return null;
        
        ListNode end=head;
        
        int i;
        
        for(i=1;i<=k-1;i++)
        {
            if(end.next==null)
                break;
            
            end=end.next;
        }
        
        if(i<k)
            return head;
        
        ListNode temp=reverseKGroup(end.next,k);
        
        end.next=null;
        
        head=reverse(head);
        
        end=head;
        
        while(end.next!=null)
            end=end.next;
        
        end.next=temp;
        
        return head;
    }
}