# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prehead=ListNode()
        prehead.next=head
        
        stack=[]
        delete=set([])
        
        curr=head
        
        while curr:
            while stack and stack[-1].val<curr.val:
                delete.add(stack.pop())
            stack.append(curr)
            curr=curr.next
        
        curr=prehead
        
        while curr.next:
            while curr.next in delete:
                curr.next=curr.next.next
            curr=curr.next
        
        return prehead.next