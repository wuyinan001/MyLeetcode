class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        n=len(heights)
        m=len(heights[0])
        ans=[]
        queue=[]
        
        P=[[False for j in range(m)] for i in range(n)]
        A=[[False for j in range(m)] for i in range(n)]
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        for i in range(n):
            P[i][0]=True
            queue.append([i,0])
        
        for j in range(m):
            P[0][j]=True
            queue.append([0,j])
        
        while queue:
            pos=queue.pop(0)
            for dir1 in dirs:
                x=pos[0]+dir1[0]
                y=pos[1]+dir1[1]
                if x>=0 and x<n and y>=0 and y<m and not P[x][y] and heights[x][y]>=heights[pos[0]][pos[1]]:
                    P[x][y]=True
                    queue.append([x,y])
        
        for i in range(n):
            A[i][m-1]=True
            queue.append([i,m-1])
        
        for j in range(m):
            A[n-1][j]=True
            queue.append([n-1,j])
        
        while queue:
            pos=queue.pop(0)
            for dir1 in dirs:
                x=pos[0]+dir1[0]
                y=pos[1]+dir1[1]
                if x>=0 and x<n and y>=0 and y<m and not A[x][y] and heights[x][y]>=heights[pos[0]][pos[1]]:
                    A[x][y]=True
                    queue.append([x,y])
        
        for i in range(n):
            for j in range(m):
                if P[i][j] and A[i][j]:
                    ans.append([i,j])
        
        return ans