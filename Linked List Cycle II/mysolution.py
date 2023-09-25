# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        set1=set([])
        
        curr=head
        
        while curr:
            if curr in set1:
                return curr
            set1.add(curr)
            curr=curr.next
        
        return None