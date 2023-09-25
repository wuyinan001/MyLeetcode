# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteNodes(self, head: ListNode, m: int, n: int) -> ListNode:
        prehead=ListNode()
        prehead.next=head
        
        slow=prehead
        fast=prehead
        
        firststep=True
        
        while fast.next:
            if firststep:
                for _ in range(m):
                    if fast.next==None:
                        break
                    slow=slow.next
                    fast=fast.next
                firststep=False
            else:
                for _ in range(n):
                    if fast.next==None:
                        break
                    fast=fast.next
                slow.next=fast.next
                firststep=True
            
        return prehead.next