class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        n=len(nums)
        nums.sort()
        WIDTH=nums[n-1]*2
        
        # multiple[i]: num of occurances of nums[i] -1
        multiple=[0 for i in range(n)]
        
        for i in range(1,n):
            if nums[i]==nums[i-1]:
                multiple[i]=multiple[i-1]+1
        
        # num of items from index 0 to i that are smaller than or equal to i
        prefix=[0 for i in range(WIDTH)]
        
        curr=0
        
        for i in range(0,WIDTH):
            while curr<n and nums[curr]<=i:
                curr+=1
            prefix[i]=curr
        
        lo=0
        hi=nums[n-1]-nums[0]
        
        while lo<hi:
            mid=(lo+hi)//2
            # sum1: the total number of pairs when the difference in the pair==mid
            sum1=0
            for i in range(n):
                sum1+=prefix[nums[i]+mid]-prefix[nums[i]]+multiple[i]
            
            if sum1>=k:
                hi=mid
            else:
                lo=mid+1
        
        return lo