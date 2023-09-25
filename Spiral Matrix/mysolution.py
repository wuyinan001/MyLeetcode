class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        
        direction=0
        n=len(matrix)
        m=len(matrix[0])
        row,col=(0,-1)
        hsteps,vsteps=(m,n-1)
        count=0
        ans=[]
        
        while count<n*m:
            
            if direction==0 or direction==2:
                for i in range(hsteps):
                    row+=dirs[direction][0]
                    col+=dirs[direction][1]
                    ans.append(matrix[row][col])
                    count+=1
                hsteps-=1
                
            if direction==1 or direction==3:
                for i in range(vsteps):
                    row+=dirs[direction][0]
                    col+=dirs[direction][1]
                    ans.append(matrix[row][col])
                    count+=1
                vsteps-=1
            
            direction=(direction+1)%4
        
        return ans