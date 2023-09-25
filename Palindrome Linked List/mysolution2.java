/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack=new Stack<Integer>();
        
        ListNode current=head;
        
        while(current!=null)
        {
            stack.push(current.val);
            current=current.next;
        }
        
        current=head;
        
        while(current!=null)
        {
            if(current.val!=stack.pop())
                return false;
            
            current=current.next;
        }
        
        return true;
    }
}