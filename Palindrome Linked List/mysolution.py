# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        stack=[]
        
        prehead=ListNode()
        prehead.next=head
        
        slow=prehead
        fast=prehead
        
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next
            stack.append(slow.val)
        
        slow=slow.next
        
        if fast==None:
            stack.pop()
            
        while slow:
            # print(stack)
            # print(slow.val)
            if stack[-1]!=slow.val:
                return False
            stack.pop()
            slow=slow.next
        
        return len(stack)==0