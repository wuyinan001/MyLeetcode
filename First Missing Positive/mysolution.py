class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        set1=set([])
        
        for i in nums:
            if i>0:
                set1.add(i)
        
        MAX=int(2e31-1)
        
        for i in range(1,MAX+1):
            if i not in set1:
                return i