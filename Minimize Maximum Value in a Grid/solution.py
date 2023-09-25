class Solution:
    def minScore(self, grid: List[List[int]]) -> List[List[int]]:
        n=len(grid)
        m=len(grid[0])
        
        nums=[]
        
        for i in range(n):
            for j in range(m):
                nums.append((grid[i][j],i,j))
        
        nums.sort()
        
        rows={}
        cols={}
        ans=[[0 for _ in range(m)] for _ in range(n)]
        
        for num,i,j in nums:
            curr=1
            if i in rows and rows[i]<num:
                curr=max(curr,1+rows[i])
                
            if j in cols and cols[j]<num:
                curr=max(curr,1+cols[j])
            
            ans[i][j]=curr
            rows[i]=curr
            cols[j]=curr
        
        return ans