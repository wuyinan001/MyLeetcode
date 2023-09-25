class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        set1=set(nums)
        
        ans=0
        
        for num in set1:
            if num+1 not in set1:
                length=1
                curr=num-1
                while curr in set1:
                    length+=1
                    curr-=1
                ans=max(ans,length)
        
        return ans