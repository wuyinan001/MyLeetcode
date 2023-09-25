import heapq
class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        pq=[]
        n=len(quality)
        
        heapq.heapify(pq)
        
        class Obj:
            def __init__(self,i):
                self.i=i
                
            def __lt__(self,other):
                return (wage[self.i]/quality[self.i])>(wage[other.i]/quality[other.i])
        
        list1=list(range(n))
        
        list1.sort(key=lambda x:quality[x])
        
        ans=float('inf')
        sum1=0
        
        for i in list1:
            heapq.heappush(pq,Obj(i))
            sum1+=quality[i]
            
            if len(pq)>k:
                sum1-=quality[heapq.heappop(pq).i]
            
            if len(pq)==k:
                ratio=wage[pq[0].i]/quality[pq[0].i]
                ans=min(ans,sum1*ratio)
        
        return ans