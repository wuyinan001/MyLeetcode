import heapq

class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        pq=[]
        heapq.heapify(pq)
        
        class Obj:
            def __init__(self,idx,endtime):
                self.idx=idx
                self.endtime=endtime
            
            def __lt__(self,other):
                if self.endtime==other.endtime:
                    return self.idx<other.idx
                return self.endtime<other.endtime
        
        freqs={}
        for key in range(n):
            freqs[key]=0
  
        for i in range(n):
            heapq.heappush(pq,Obj(i,0))
        
        meetings.sort()
        
        queue=[]
        
        for meeting in meetings:
            while pq and pq[0].endtime<=meeting[0]:
                curr=heapq.heappop(pq)
                queue.append(Obj(curr.idx,meeting[0]))
                
            while queue:
                heapq.heappush(pq,queue.pop(0))
                
            curr=heapq.heappop(pq)
            curr.endtime=meeting[1]+max(0,curr.endtime-meeting[0])
            freqs[curr.idx]+=1
            heapq.heappush(pq,Obj(curr.idx,curr.endtime))
            #print(freqs)
        
        keys=[i for i in range(n)]
        
        keys.sort(key=lambda x:(-freqs[x],x))
        
        #print("keys",keys)
        
        return keys[0]