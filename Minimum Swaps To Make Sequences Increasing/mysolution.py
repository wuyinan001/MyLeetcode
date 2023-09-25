class Solution:
    def minSwap(self, nums1: List[int], nums2: List[int]) -> int:
        n=len(nums1)
        dp1=[inf for i in range(n)]
        dp2=[inf for i in range(n)]
        
        dp1[0]=0
        dp2[0]=1
        
        for i in range(1,n):
            if nums1[i]>nums1[i-1] and nums2[i]>nums2[i-1]:
                dp1[i]=dp1[i-1]
                dp2[i]=dp2[i-1]+1
            
            if nums1[i]>nums2[i-1] and nums2[i]>nums1[i-1]:
                dp1[i]=min(dp1[i],dp2[i-1])
                dp2[i]=min(dp2[i],dp1[i-1]+1)
        
        return min(dp1[n-1],dp2[n-1])