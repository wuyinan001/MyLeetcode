/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        int n=0;
        
        ListNode curr=head;
        
        while(curr!=null)
        {
            n++;
            curr=curr.next;
        }
        
        if(n<=1)
            return head;
        
        curr=head;
        
        for(int i=1;i<n/2;i++)
        {
            curr=curr.next;
        }
        
        ListNode head2=curr.next;
        curr.next=null;
        
        //printList(head);
        //printList(head2);
        
        return mergeList(sortList(head),sortList(head2));
    }
    
    private void printList(ListNode l)
    {
        ListNode curr=l;
        
        while(curr!=null)
        {
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    
    
    private ListNode mergeList(ListNode l1, ListNode l2)
    {
        if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
        
        ListNode ans=new ListNode(Math.min(l1.val,l2.val));
        ListNode i,j;
        ListNode curr=ans;
        
        if(l1.val<=l2.val)
        {
            i=l1.next;
            j=l2;
        }
        else
        {
            i=l1;
            j=l2.next;
        }
            
        
        while(i!=null||j!=null)
        {
            if(i==null)
            {
                curr.next=j;
                return ans;
            }
            else if(j==null)
            {
                curr.next=i;
                return ans;
            }
            else if(i.val<=j.val)
            {
                curr.next=new ListNode(i.val);
                curr=curr.next;
                i=i.next;
            }
            else
            {
                curr.next=new ListNode(j.val);
                curr=curr.next;
                j=j.next;
            }
        }
        
        return ans;
    }
}