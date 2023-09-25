class Solution:
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        small=0
        large=0
        n=len(nums)
        
        for i in nums:
            if i<target:
                small+=1
            elif i>target:
                large+=1
        
        if small+large==n:
            return []
        else:
            return list(range(small,n-large))