class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        set1=set([])
        
        # If the number appears twice, it will be removed from set1;
        # otherwise it will be kept in the set1;
        # In the end, there is only one number in the set1
        for i in nums:
            if i in set1:
                set1.remove(i)
            else:
                set1.add(i)
        
        return next(iter(set1))