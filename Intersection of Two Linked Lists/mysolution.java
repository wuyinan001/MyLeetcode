/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null||headB==null)
            return null;
        
        List<ListNode> list=new ArrayList<>();
        
        ListNode curr=headA;
        
        while(curr!=null)
        {
            list.add(curr);
            curr=curr.next;
        }
        
        curr=headB;
        
        while(curr!=null)
        {
            if(list.contains(curr))
                return curr;
            curr=curr.next;
        }
        
        return curr;
    }
}