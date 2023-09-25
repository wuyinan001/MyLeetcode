class Solution:
    def minSwaps(self, data: List[int]) -> int:
        ones=sum(data)
        
        n=len(data)
        
        ans=n
        
        sum1=0
        
        for i in range(n):
            sum1+=data[i]
            if i>=ones:
                sum1-=data[i-ones]
            ans=min(ans,ones-sum1)
        
        return ans