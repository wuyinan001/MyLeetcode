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
    public ListNode mergeKLists(ListNode[] lists) {
        
        return mergeKLists(lists,0,lists.length-1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int lo, int hi)
    {
        if(lo>hi)
            return null;
        
        if(lo==hi)
            return lists[lo];
        
        int mid=lo+(hi-lo)/2;
        
        ListNode l1=mergeKLists(lists,lo,mid);
        ListNode l2=mergeKLists(lists,mid+1,hi);
        
        return mergeTwoLists(l1,l2);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode prehead=new ListNode();
        ListNode curr=prehead;
        
        while(l1!=null&&l2!=null)
        {
            if(l1.val<=l2.val)
            {
                curr.next=l1;
                l1=l1.next;
            }
            else
            {
                curr.next=l2;
                l2=l2.next;
            }
            
            curr=curr.next;
        }
        
        if(l1!=null)
            curr.next=l1;
        
        if(l2!=null)
            curr.next=l2;
        
        return prehead.next;
    }
}