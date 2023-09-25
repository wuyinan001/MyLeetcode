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
    public ListNode oddEvenList(ListNode head) {
        
        if(head==null||head.next==null||head.next.next==null)
            return head;
        
        ListNode odd=head, even=head.next, temp=head.next;
        
        while(odd.next!=null&&even.next!=null)
        {
            odd.next=even.next;
            if(odd.next==null)
                break;
            odd=odd.next;
            
            even.next=odd.next;
            if(even.next==null)
                break;
            even=even.next;
        }
        
        odd.next=temp;
        
        return head;
    }
}