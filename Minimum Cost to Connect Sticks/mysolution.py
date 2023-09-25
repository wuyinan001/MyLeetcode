import heapq

class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        pq=[]
        heapq.heapify(pq)
        
        ans=0
        
        for i in sticks:
            heapq.heappush(pq,i)
        
        while len(pq)>1:
            a1=heapq.heappop(pq)
            a2=heapq.heappop(pq)
            ans+=a1+a2
            heapq.heappush(pq,a1+a2)
        
        return ans