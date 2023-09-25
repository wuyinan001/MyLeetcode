class Solution:
    # Max points to delete number from 0 to num
    def dp(self,num,gain,memo):
        if memo[num]!=None:
            return memo[num]
        
        ans=max(self.dp(num-2,gain,memo)+gain[num],self.dp(num-1,gain,memo))
        memo[num]=ans
        
        return ans
    
    def deleteAndEarn(self, nums: List[int]) -> int:
        max1=max(nums)
        
        # freq[i]: Number of occurances of num i
        freq={}
        
        for i in nums:
            freq[i]=freq.get(i,0)+1
        
        # gain[i]: Number of points for num i (i*freq[i])
        gain={}
        
        for i in range(max1+1):
            if i not in freq:
                gain[i]=0
            else:
                gain[i]=freq[i]*i
            
        memo=[None for i in range(max1+1)]
        memo[0]=0
        memo[1]=gain[1]
        
        return self.dp(max1,gain,memo)