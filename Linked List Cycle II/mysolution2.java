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
        
        ListNode slow=head, fast=head;
        boolean cycle=false;
        
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            {
                cycle=true;
                break;
            }
        }
        
        if(cycle)
        {
            Map<ListNode,Integer> map=new HashMap();
            slow=head;
            while(slow!=null)
            {
                map.put(slow,map.getOrDefault(slow,0)+1);
                if(map.get(slow)>1)
                    return slow;
                
                slow=slow.next;
            }
        }
        
        return null;
    }
}