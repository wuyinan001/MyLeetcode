# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1=headA
        l2=headB
        
        while l1:
            while l2:
                if l1==l2:
                    return l2
                l2=l2.next
            l2=headB
            l1=l1.next
        
        return None