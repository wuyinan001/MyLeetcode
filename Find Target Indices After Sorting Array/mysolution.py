# I misunderstood this problem at the first glance.
# I thought this problem requires to sort nums and find target index. If so, this solution works.
# Actually this problem only requires to find target index. This solution still works but not the optimal solution.
# There is a better solution under this solution within comment

class Solution:
    def __init__(self):
        self.ans=[]
    
    def swap(self,nums,i,j):
        t=nums[i]
        nums[i]=nums[j]
        nums[j]=t
    
    def sort(self,nums,lo,hi,target):
        if lo>hi:
            return
        
        v=nums[lo]
        
        # lt: the first index of value v; ht: the last index of value v
        
        lt=lo
        ht=hi
        i=lo+1
        
        while i<=ht:
            if nums[i]<v:
                self.swap(nums,lt,i)
                lt+=1
                i+=1
            elif nums[i]>v:
                self.swap(nums,i,ht)
                ht-=1
            else:
                i+=1
        
        if v==target:
            self.ans=list(range(lt,ht+1))
            
        self.sort(nums,lo,lt-1,target)
        self.sort(nums,ht+1,hi,target)
        
    
    def targetIndices(self, nums: List[int], target: int) -> List[int]:
        self.sort(nums,0,len(nums)-1,target)
        
        return self.ans

'''
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
'''