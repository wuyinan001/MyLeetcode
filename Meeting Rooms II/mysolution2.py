import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        n=len(intervals)
        
        intervals.sort(key=lambda x:x[0])
        
        pq=[]
        heapq.heapify(pq)
        ans=0
        
        for interval in intervals:
            while pq and interval[0]>=pq[0]:
                heapq.heappop(pq)
            
            heapq.heappush(pq,interval[1])
            
            ans=max(ans,len(pq))
        
        return ans