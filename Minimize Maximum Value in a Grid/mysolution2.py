class Solution:
    def minScore(self, grid: List[List[int]]) -> List[List[int]]:
        n=len(grid)
        m=len(grid[0])
        
        rows={}
        cols={}
        
        list1=[]
        
        for i in range(n):
            for j in range(m):
                list1.append((grid[i][j],i,j))
        
        list1.sort()
        
        ans=[[1 for _ in range(m)] for _ in range(n)]
        
        for _,r,c in list1:
            if r in rows:
                ans[r][c]=max(ans[r][c],rows[r]+1)
                
            if c in cols:
                ans[r][c]=max(ans[r][c],cols[c]+1)
            
            rows[r]=ans[r][c]
            cols[c]=ans[r][c]
        
        return ans