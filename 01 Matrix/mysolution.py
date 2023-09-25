class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n=len(mat)
        m=len(mat[0])
        #visited=[[False for j in range(m)] for i in range(n)]
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        ans=[[-1 for j in range(m)] for i in range(n)]
        queue=[]
        
        for i in range(n):
            for j in range(m):
                if mat[i][j]==0:
                    ans[i][j]=0
                    queue.append((i,j))
        
        step=1
        while queue:
            size=len(queue)
            for i in range(size):
                curr=queue.pop(0)
                for dir1 in dirs:
                    x=curr[0]+dir1[0]
                    y=curr[1]+dir1[1]
                    if x>=0 and x<n and y>=0 and y<m and ans[x][y]==-1:
                        ans[x][y]=step
                        queue.append((x,y))
                        
            step+=1
        
        return ans