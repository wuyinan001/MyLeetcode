# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head==None or head.next==None:
            return head
        
        head.next.next=self.swapPairs(head.next.next)
        
        ans=head.next
        head.next=head.next.next
        ans.next=head
        
        return ans