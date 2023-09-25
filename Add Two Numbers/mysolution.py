# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ans=ListNode(-1)
        curr=ans
        carry=0
        
        while l1!=None and l2!=None:
            sum1=l1.val+l2.val+carry
            curr.next=ListNode(sum1%10)
            carry=int(sum1/10)
            l1=l1.next
            l2=l2.next
            curr=curr.next
        
        while l1!=None:
            sum1=l1.val+carry
            curr.next=ListNode(sum1%10)
            carry=int(sum1/10)
            l1=l1.next
            curr=curr.next
        
        while l2!=None:
            sum1=l2.val+carry
            curr.next=ListNode(sum1%10)
            carry=int(sum1/10)
            l2=l2.next
            curr=curr.next
        
        if carry!=0:
            curr.next=ListNode(carry)
        
        return ans.next