# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeSort(self,l1,l2):
        prehead=ListNode()
        curr=prehead
        
        while l1 and l2:
            if l1.val<=l2.val:
                curr.next=l1
                l1=l1.next
            else:
                curr.next=l2
                l2=l2.next
            curr=curr.next
        
        if l1:
            curr.next=l1
        
        if l2:
            curr.next=l2
        
        return prehead.next
        
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head==None or head.next==None:
            return head
        
        slow=head
        fast=head
        
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        
        mid=slow.next
        slow.next=None
        
        ans=self.mergeSort(self.sortList(head),self.sortList(mid))
        
        return ans