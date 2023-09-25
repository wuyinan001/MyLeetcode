/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        
        if(n==0)
            return null;
        
        ListNode result=null,current=null;
        
        List<ListNode> heads=new ArrayList<>();
        int size=n;
        
        for(int i=0;i<n;i++)
        {
            if(lists[i]==null)
                size--;
            else
                heads.add(lists[i]);
        }
        
        while(!heads.isEmpty())
        {
                
            int min=heads.get(0).val;
            int min_index=0;
            
            for(int i=1;i<size;i++)
            {
                if(min>heads.get(i).val)
                {
                    min=heads.get(i).val;
                    min_index=i;
                }
            }
            
            if(result==null)
            {
                result=new ListNode(min);
                current=result;
            }
            else
            {
                current.next=new ListNode(min);
                current=current.next;
            }
            
            
            heads.set(min_index,heads.get(min_index).next);
            
            if(heads.get(min_index)==null)
            {
                size--;
                heads.remove(min_index);
            }
        }
        
        return result;
    }
}