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
            return  head;
        
        ListNode tail=head.next;
        
        ListNode ans=reverse(head.next);
        
        tail.next=head;
        head.next=null;
        
        return ans;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode curr=head, cache=head;
        int count=0;
        
        while(curr!=null)
        {
            // Save the kth node as cache node
            if(count==k-1)
            {
                cache=curr;
            }
            
            if(count==k)
                break;
            
            count++;
            curr=curr.next;
        }
        
        if(count<k)
            return  head;

        cache.next=reverseKGroup(cache.next,k);
        
        ListNode temp=cache.next;
        cache.next=null;

        ListNode ans=reverse(head);
        
        head.next=temp;
        
        return ans;
    }
}