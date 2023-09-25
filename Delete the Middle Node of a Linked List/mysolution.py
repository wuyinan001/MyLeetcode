# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prehead=ListNode()
        prehead.next=ListNode()
        prehead.next.next=head
        
        fast=prehead
        slow=prehead
        
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
        
        slow.next=slow.next.next
        
        return prehead.next.next