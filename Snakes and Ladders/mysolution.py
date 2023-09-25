class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n=len(board)
        map1={}
        
        count=1
        right=True
        
        for i in range(n-1,-1,-1):
            if right:
                for j in range(0,n):
                    map1[count]=[i,j]
                    count+=1
                right=False
            else:
                for j in range(n-1,-1,-1):
                    map1[count]=[i,j]
                    count+=1
                right=True
        
        visited=[[False for j in range(n)] for i in range(n)]
        
        queue=[]
        
        queue.append(1)
        visited[n-1][0]=True
        
        step=0
        
        while queue:
            size=len(queue)
            for i in range(size):
                pos=queue.pop(0)
                if pos==n*n:
                    return step
                
                for j in range(1,min(6,n*n-pos)+1):
                    [x,y]=map1[pos+j]
                    if not visited[x][y]:
                        visited[x][y]=True
                        if board[x][y]!=-1:
                            queue.append(board[x][y])
                        else:
                            queue.append(pos+j)
                
            step+=1
        
        return -1