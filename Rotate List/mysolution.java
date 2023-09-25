/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int[] a=new int[1000];
        
        int size=0;
        
        ListNode current=head;
        int i=0;
        while(current!=null)
        {
            a[i++]=current.val;
            current=current.next;
            size++;
        }
        
        ListNode result=null;
        
        if(size==0)
            return result;
    
            
        int j;
        
        if(k%size==0)
            j=size-1;
        else if(size-k<0)
        {
            int n=1;
            while(n*size-k<0)
                n++;
            
            j=(n*size-k)%size-1;
        }
        else
            j=(size-k)%size-1;
        
        
        result=new ListNode(a[j]);
        int count=size-1;
        
        while(count>0)
        {
            count--;
            
            if(j-1<0)
                j=j+size;
            j=(j-1)%size;
            current=new ListNode(a[j]);
            current.next=result;
            result=current;
        }
        
        return result;
    }
}