class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        n=len(nums)
        dict1={0:-1}

        sum1=0
        ans=float('inf')

        for i in range(n):
            sum1+=nums[i]
            prev_sum=sum1-k
            for key in dict1:
                if key<=prev_sum and ans>i-dict1[key]:
                    ans=i-dict1[key]
            dict1[sum1]=i
        
        return ans if ans!=float('inf') else -1