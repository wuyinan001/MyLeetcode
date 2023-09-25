class Solution:
    def minScore(self, grid: List[List[int]]) -> List[List[int]]:
        n=len(grid)
        m=len(grid[0])
        nums=[]
        
        for i in range(n):
            for j in range(m):
                nums.append((grid[i][j],i,j))
        
        nums.sort()
        
        ans=[[0 for _ in range(m)] for _ in range(n)]
        
        rows={}
        cols={}
        
        for _,r,c in nums:
            curr=1
            if r in rows:
                curr=max(curr,rows[r]+1)
            
            if c in cols:
                curr=max(curr,cols[c]+1)
            
            ans[r][c]=curr
            rows[r]=curr
            cols[c]=curr
        
        return ans