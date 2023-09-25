# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        l1=headA
        l2=headB
        
        set1=set([])
        
        while l1:
            set1.add(l1)
            l1=l1.next
            
        while l2:
            if l2 in set1:
                return l2
            l2=l2.next
        
        return None