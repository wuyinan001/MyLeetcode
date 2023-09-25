import heapq

class Position:
    def __init__(self,x,y,label):
        self.x=x
        self.y=y
        self.label=label
        
    def __lt__(self,other):
        if self.x==other.x:
            if self.label==other.label:
                if self.label=="s":
                    return self.y>=other.y
                else:
                    return self.y<other.y
            else:
                return self.label>=other.label
        else:
            return self.x<other.x

class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        positions=[]
        for b in buildings:
            positions.append(Position(b[0],b[2],"s"))
            positions.append(Position(b[1],b[2],"e"))
        
        positions.sort()
        
        ans=[]
        pq=[]
        
        heapq.heapify(pq)
        
        heapq.heappush(pq,0)
        
        for pos in positions:
            if pos.label=="s":
                if pos.y>-pq[0]:
                    ans.append([pos.x,pos.y])
                heapq.heappush(pq,-pos.y)
            else:
                pq.remove(-pos.y)
                heapq.heapify(pq)
                if pos.y>-pq[0]:
                    ans.append([pos.x,-pq[0]])
        
        return ans