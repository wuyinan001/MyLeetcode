import heapq

class Obj:
    def __init__(self,exit,num):
        self.exit=exit
        self.num=num
        
    def __lt__(self,other):
        return self.exit<other.exit

class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        pq=[]
        heapq.heapify(pq)
        trips.sort(key=lambda x:x[1])
        
        sum1=0
        
        for trip in trips:
            while pq and pq[0].exit<=trip[1]:
                sum1-=heapq.heappop(pq).num
            
            sum1+=trip[0]
            heapq.heappush(pq,Obj(trip[2],trip[0]))
            
            if sum1>capacity:
                return False
        
        return True