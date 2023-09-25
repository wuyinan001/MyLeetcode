# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self,node):
        if node==None or node.next==None:
            return node
        
        tmp=node.next
        node.next=None
        ans=self.reverse(tmp)
        tmp.next=node
        
        return ans
        
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        count=0
        
        curr=head
        
        while curr:
            count+=1
            if count==k:
                break
            curr=curr.next
            
        if count<k:
            return head
        
        tmp=self.reverseKGroup(curr.next,k)
        curr.next=None
        ans=self.reverse(head)
        head.next=tmp
        
        return ans