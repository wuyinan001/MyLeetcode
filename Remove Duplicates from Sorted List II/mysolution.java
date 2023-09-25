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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode prehead=new ListNode(-1);
        prehead.next=head;
        ListNode prev=prehead;
        ListNode curr=head;
        // Find dup values
        boolean dup=false;

        while(curr!=null&&curr.next!=null)
        {
            if(!dup)
            {
                if(curr.next.val==curr.val)
                {
                    curr.next=curr.next.next;
                    dup=true;
                }
                else {
                    prev = prev.next;
                    curr = curr.next;
                }
            }
            else {
                if (curr.next.val == curr.val) {
                    curr.next = curr.next.next;
                } else {
                    prev.next = curr.next;
                    curr = prev.next;
                    dup = false;
                }
            }
        }

        if(dup)
            prev.next=null;

        return prehead.next;
        
    }
}