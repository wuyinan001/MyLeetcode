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
        int[] array=new int[50000];
        
        int n=0;
        
        ListNode current=head;
        
        while(current!=null)
        {
            array[n++]=current.val;
            current=current.next;
        }
        
        int i=0,j=n-1;
        
        while(i<j)
        {
            if(array[i++]!=array[j--])
                return false;
        }
        
        return true;
    }
}