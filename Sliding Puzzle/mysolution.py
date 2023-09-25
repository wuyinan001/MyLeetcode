class Solution:
    def __init__(self):
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
    def findNeighbors(self,s):
        ans=[]
        
        index=-1
        
        for i in range(6):
            if s[i]=='0':
                index=i
                break
                
        x=int(index/3)
        y=index%3
        
        for dir1 in self.dirs:
            xx=x+dir1[0]
            yy=y+dir1[1]
            if xx>=0 and xx<2 and yy>=0 and yy<3:
                idx=xx*3+yy
                tmp=list(s)        
                t=tmp[index]
                tmp[index]=tmp[idx]
                tmp[idx]=t
                ans.append(''.join(tmp))
        
        return ans
        
    def slidingPuzzle(self, board: List[List[int]]) -> int:
        s=""
        for i in range(2):
            for j in range(3):
                s=s+str(board[i][j])
                
        visited=set([s])
        queue=[s]
        step=0
        
        while queue:
            size=len(queue)
            for _ in range(size):
                curr=queue.pop(0)
                if curr=="123450":
                    return step
                
                for v in self.findNeighbors(curr):
                    if v not in visited:
                        queue.append(v)
                        visited.add(v)
            
            step+=1
            
        return -1