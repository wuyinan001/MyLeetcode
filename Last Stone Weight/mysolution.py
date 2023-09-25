import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        pq=[]
        heapq.heapify(pq)

        for i in stones:
            heapq.heappush(pq,-i)
        
        while len(pq)>1:
            x=-heapq.heappop(pq)
            y=-heapq.heappop(pq)
            z=abs(x-y)
            if z!=0:
                heapq.heappush(pq,-z)
            
        if len(pq)==1:
            return -pq[0]
        else:
            return 0