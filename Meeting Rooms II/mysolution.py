import heapq

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        
        #print(intervals)
        
        class MyObjects:
            def __init__(self,val0,val1):
                self.val0=val0
                self.val1=val1
                
            def __repr__(self):
                return "[{},{}]".format(self.val0,self.val1)
                
            def __lt__(self,other):
                return self.val1<other.val1
        
        pq=[]
        heapq.heapify(pq)
        
        ans=0
        
        for interval in intervals:
            
            while pq and interval[0]>=pq[0].val1:
                heapq.heappop(pq)
            
            heapq.heappush(pq,MyObjects(interval[0],interval[1]))
            ans=max(ans,len(pq))
            
        return ans