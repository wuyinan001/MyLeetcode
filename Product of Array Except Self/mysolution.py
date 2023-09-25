class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n=len(nums)
        L=[0 for i in range(n)]
        R=[0 for i in range(n)]
        
        L[0]=nums[0]
        for i in range(1,n):
            L[i]=nums[i]*L[i-1]
            
        R[n-1]=nums[n-1]
        for i in range(n-2,-1,-1):
            R[i]=nums[i]*R[i+1]
        
        ans=[0 for i in range(n)]
        ans[0]=R[1]
        ans[n-1]=L[n-2]
        
        for i in range(1,n-1):
            ans[i]=L[i-1]*R[i+1]
        
        return ans