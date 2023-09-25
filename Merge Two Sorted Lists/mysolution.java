/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i=l1;
        ListNode j=l2;
        
        if(i==null)
            return j;
            
        if(j==null)
            return i;
        
        // First node is dummy node
        ListNode result=new ListNode(0);
        ListNode current=result;
        
        while(i!=null||j!=null)
        {
            if(i==null)
            {
                current.next=j;
                break;
            }
            else if(j==null)
            {   
                current.next=i;
                break;
            }
            else if(i.val<j.val)
            {
                current.next=new ListNode(i.val);
                i=i.next;
                current=current.next;
            }
            else
            {
                current.next=new ListNode(j.val);
                j=j.next;
                current=current.next;
            }
                
        }
        
        return result.next;
    }
    
    
}