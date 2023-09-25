class Solution:
    def dp(self,array,left,right,memo):
        if right<=left+1:
            return 0
        
        if memo[left][right]!=None:
            return memo[left][right]
        
        ans=0
        for i in range(left+1,right):
            ans=max(ans,self.dp(array,left,i,memo)+self.dp(array,i,right,memo)
                    +array[i]*array[left]*array[right])
        
        memo[left][right]=ans
        return ans
        
    def maxCoins(self, nums: List[int]) -> int:
        array=nums[:]
        array.append(1)
        array.insert(0,1)
        n=len(array)
        memo=[[None for j in range(n)] for i in range(n)]
        
        return self.dp(array,0,n-1,memo)