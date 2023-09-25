class Solution:
    def numOfBits(self,n):
        ans=0
        while n>0:
            ans+=n&1
            n=n>>1
        
        return ans
        
    def countBits(self, n: int) -> List[int]:
        ans=[]
        for i in range(n+1):
            ans.append(self.numOfBits(i))
        
        return ans