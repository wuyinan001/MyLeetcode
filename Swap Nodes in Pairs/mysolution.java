/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current=head;
        ListNode prev=null;
        
        while(current!=null&&current.next!=null)
        {
            ListNode temp=current.next;
 
            current.next=temp.next;
            temp.next=current;
            
            if(current==head)
                head=temp;
            else
                prev.next=temp;
            
            prev=current;
            current=current.next;
        }
        
        return head;
    }
}