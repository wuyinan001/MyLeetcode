import heapq

class Obj:
    def __init__(self,val,freq,pos):
        self.val=val
        self.freq=freq
        self.pos=pos
    
    def __lt__(self,other):
        return self.freq>other.freq

class Solution:
    def rearrangeBarcodes(self, barcodes: List[int]) -> List[int]:
        n=len(barcodes)
        ans=[0 for i in range(n)]

        dict1={}

        for i in barcodes:
            dict1[i]=dict1.get(i,0)+1

        pq=[]

        heapq.heapify(pq)
        queue=[]

        for key in dict1:
            heapq.heappush(pq,Obj(key,dict1[key],0))

        for i in range(n):
            while queue and queue[0].pos<=i:
                heapq.heappush(pq,queue.pop(0))
            
            curr=heapq.heappop(pq)
            ans[i]=curr.val

            curr.freq-=1
            curr.pos=i+2

            if curr.freq>0:
                queue.append(curr)
        
        return ans