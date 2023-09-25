# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

import heapq

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq=[]
        heapq.heapify(pq)
        
        for list1 in lists:
            curr=list1
            while curr!=None:
                heapq.heappush(pq,curr.val)
                curr=curr.next
        
        prehead=ListNode()
        curr=prehead
        
        while pq:
            curr.next=ListNode(heapq.heappop(pq))
            curr=curr.next
            
        return prehead.next