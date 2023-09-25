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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        
        ListNode prehead=new ListNode();
        prehead.next=head;
        
        Map<Integer,Integer> map=new HashMap();
        
        ListNode curr=head;
        while(curr!=null)
        {
            map.put(curr.val,map.getOrDefault(curr.val,0)+1);
            curr=curr.next;
        }
        
        curr=prehead;
        
        while(curr.next!=null)
        {
            if(map.get(curr.next.val)>1)
                curr.next=curr.next.next;
            else
                curr=curr.next;
        }
        
        return prehead.next;
    }
}