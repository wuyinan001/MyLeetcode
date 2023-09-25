# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head==None or head.next==None or head.next.next==None:
            return
        
        nextHead=head.next
        curr=head
        
        while curr.next.next!=None:
            curr=curr.next
        
        head.next=curr.next
        curr.next=None
        
        self.reorderList(nextHead)
        
        head.next.next=nextHead