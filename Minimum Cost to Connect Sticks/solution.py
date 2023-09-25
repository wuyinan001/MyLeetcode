import heapq

class Solution:
    def connectSticks(self, sticks: List[int]) -> int:
        pq=[]
        heapq.heapify(pq)

        for i in sticks:
            heapq.heappush(pq,i)
        
        ans=0

        while len(pq)>1:
            sum1=heapq.heappop(pq)
            sum1+=heapq.heappop(pq)
            ans+=sum1
            heapq.heappush(pq,sum1)
        
        return ans