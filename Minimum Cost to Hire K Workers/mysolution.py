import heapq

class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        n=len(wage)
        pq=[]
        heapq.heapify(pq)
        index_list=[i for i in range(n)]
        
        index_list.sort(key=lambda x:quality[x])
        
        class MyObjs:
            def __init__(self,idx):
                self.idx=idx
            
            def __lt__(self,other):
                return wage[self.idx]/quality[self.idx]>wage[other.idx]/quality[other.idx]
        
        ans=inf
        sum1=0
        
        for i in index_list:
            sum1+=quality[i]
            heapq.heappush(pq,MyObjs(i))
            if len(pq)==k:
                id_remove=heapq.heappop(pq).idx
                ratio=wage[id_remove]/quality[id_remove]
                ans=min(ans,sum1*ratio)
                sum1-=quality[id_remove]
                
        return ans