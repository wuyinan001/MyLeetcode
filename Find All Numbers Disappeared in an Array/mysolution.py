class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n=len(nums)
        set1=set(list(range(1,n+1)))
        
        for i in nums:
            if i in set1:
                set1.remove(i)
        
        ans=[]
        
        for i in set1:
            ans.append(i)
            
        return ans