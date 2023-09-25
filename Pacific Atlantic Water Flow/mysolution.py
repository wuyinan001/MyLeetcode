import numpy as np

class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n=len(heights)
        m=len(heights[0])
        
        P=np.zeros((n,m),dtype=bool)
        A=np.zeros((n,m),dtype=bool)
        
        queue=[]
        visited=np.zeros((n,m),dtype=bool)
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        for j in range(m):
            P[0][j]=True
            
        for i in range(n):
            P[i][0]=True
        
        for i in range(n):
            for j in range(m):
                if P[i][j] and not visited[i][j]:
                    visited[i][j]=True
                    queue.append([i,j])
                    while queue:
                        temp=queue.pop(0)
                        for dir1 in dirs:
                            x=temp[0]+dir1[0]
                            y=temp[1]+dir1[1]
                            if x>=0 and x<n and y>=0 and y<m and not visited[x][y] and heights[x][y]>=heights[temp[0]][temp[1]]:
                                P[x][y]=True
                                visited[x][y]=True
                                queue.append([x,y])
        
        visited[:]=False
        
        for j in range(m):
            A[-1][j]=True
            
        for i in range(n):
            A[i][-1]=True
        
        for i in range(n):
            for j in range(m):
                if A[i][j] and not visited[i][j]:
                    visited[i][j]=True
                    queue.append([i,j])
                    while queue:
                        temp=queue.pop(0)
                        for dir1 in dirs:
                            x=temp[0]+dir1[0]
                            y=temp[1]+dir1[1]
                            if x>=0 and x<n and y>=0 and y<m and not visited[x][y] and heights[x][y]>=heights[temp[0]][temp[1]]:
                                A[x][y]=True
                                visited[x][y]=True
                                queue.append([x,y])
        
        ans=[]
        for i in range(n):
            for j in range(m):
                if P[i][j] and A[i][j]:
                    ans.append([i,j])
        
        return ans