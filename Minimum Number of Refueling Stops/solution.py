import heapq

class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        # current fuel
        fuel=startFuel
        stations.sort(key=lambda x:x[0])
        # min stops
        ans=0
        # prev pos
        prev=0
        # max heap to store the fuel of each station
        # pq store -fuel because pq is min heap
        pq=[]
        heapq.heapify(pq)
        
        for s in stations:
            # Find how much gas left after reaching the next station. If fuel<0, that means
            # it needs to fill gas before reaching next station
            fuel+=prev-s[0]
            while fuel<0 and pq:
                fuel+=-heapq.heappop(pq)
                ans+=1
            
            if fuel<0:
                return -1
            
            heapq.heappush(pq,-s[1])
            prev=s[0]
            
            if prev>=target:
                return ans
        
        fuel+=prev-target
        while fuel<0 and pq:
            fuel+=-heapq.heappop(pq)
            ans+=1
        
        return ans if fuel>=0 else -1