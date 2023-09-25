import heapq

class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        ans=[]
        list1=[]
        pq=[]
        heapq.heapify(pq)
        
        for l in firstList:
            list1.append(l)
        
        for l in secondList:
            list1.append(l)
        
        list1.sort(key=lambda x:(x[0],x[1]))
        
        n=len(list1)
        
        for interval in list1:
            while pq and interval[0]>pq[0]:
                heapq.heappop(pq)
            
            if pq and pq[0]>=interval[0]:
                ans.append([interval[0],min(interval[1],pq[0])])
            
            heapq.heappush(pq,interval[1])
        
        return ans