# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self,head):
        if head==None or head.next==None:
            return head
        
        temp=head.next
        head.next=None
        ans=self.reverse(temp)
        temp.next=head
        
        return ans
    
    def merge(self,l1,l2):
        prehead=ListNode()
        curr=prehead
        one=True
        
        while l1 or l2:
            if one:
                curr.next=l1
                l1=l1.next
                one=False
            else:
                curr.next=l2
                l2=l2.next
                one=True
            
            curr=curr.next
        
        return prehead.next
    
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        prehead=ListNode()
        prehead.next=head
        slow=prehead
        fast=prehead
        
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        
        l2=slow.next
        slow.next=None
        l2=self.reverse(l2)
        
        return self.merge(head,l2)