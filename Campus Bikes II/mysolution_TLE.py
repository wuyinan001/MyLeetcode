class Solution:
    
    def __init__(self):
        self.ans=inf
    
    def backTrack(self,workers,w,bikes,sum1,visited):
        if sum1>=self.ans:
            return
        
        if w==len(workers):
            self.ans=min(self.ans,sum1)
            return 
        
        for i in range(len(bikes)):
            if not visited[i]:
                visited[i]=True
                d=abs(workers[w][0]-bikes[i][0])+abs(workers[w][1]-bikes[i][1])
                self.backTrack(workers,w+1,bikes,sum1+d,visited)
                visited[i]=False
        
    
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> int:
        m=len(bikes)
        visited=[False for i in range(m)]
        self.backTrack(workers,0,bikes,0,visited)
        return self.ans