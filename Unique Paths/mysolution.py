class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        L=[[0 for j in range(n)] for i in range(m)]
        
        for i in range(m):
            L[i][0]=1
            
        for j in range(n):
            L[0][j]=1
        
        for i in range(1,m):
            for j in range(1,n):
                L[i][j]=L[i-1][j]+L[i][j-1]
        
        return L[m-1][n-1]