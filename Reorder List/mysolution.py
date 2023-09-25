# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    def reverseList(self,head):
        if head==None or head.next==None:
            return head
        
        temp=head.next
        head.next=None
        
        ans=self.reverseList(temp)
        temp.next=head
        
        return ans
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None or head.next.next==None:
            return 
        
        # find the mid node(slow)
        slow=head
        fast=head
        
        while fast!=None and fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        
        list2=slow.next
        slow.next=None
        
        # flip the second list
        list2=self.reverseList(list2)
        
        # merge the first list and second list
        ans=head
        curr=head
        head=head.next
        one=True
        
        while head!=None or list2!=None:
            if one:
                curr.next=list2
                list2=list2.next
                one=False
            else:
                curr.next=head
                head=head.next
                one=True
            
            curr=curr.next
        
        return ans