class Solution:
    def findLengthOfShortestSubarray(self, arr: List[int]) -> int:
        n=len(arr)
        
        l=0
        r=n-1
        
        while l<n-1 and arr[l]<=arr[l+1]:
            l+=1
        
        if l==n-1:
            return 0
        
        while r>0 and arr[r-1]<=arr[r]:
            r-=1
        
        ans=min(n-1-l,r)
        
        for i in range(l+1):
            if arr[i]<=arr[r]:
                ans=min(ans,r-1-i)
            elif r<n-1:
                r+=1
            else:
                break
        
        return ans