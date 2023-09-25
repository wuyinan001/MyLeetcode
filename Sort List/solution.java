/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head==null||head.next==null)
            return head;
        
        ListNode fast=head,mid=head,prev=head;
        
        // mid will point to the middle of node;
        // prev will point to the node before the middle node;
        
        while(fast!=null&&fast.next!=null)
        {
            prev=mid;
            fast=fast.next.next;
            mid=mid.next;
        }
        
        // Cut the second half of list from the head list
        prev.next=null;
        
        return mergeList(sortList(head),sortList(mid));
    }
    
    private void printList(ListNode l)
    {
        ListNode curr=l;
        
        while(curr!=null)
        {
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    
    
    private ListNode mergeList(ListNode l1, ListNode l2)
    {
        if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
        
        if(l1.val<=l2.val)
        {
            l1.next=mergeList(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next=mergeList(l1,l2.next);
            return l2;
        }
    }
}