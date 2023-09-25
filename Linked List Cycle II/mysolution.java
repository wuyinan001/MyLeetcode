/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode i=head;
        Set<ListNode> s=new HashSet<ListNode>();
        int old_size=0;
        
        while(i!=null)
        {
            s.add(i);
            
            if(old_size==s.size())
                return i;
            
            old_size=s.size();
            i=i.next;
        
        }
        
        return null;
    }
}