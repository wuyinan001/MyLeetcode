class Solution:
    def __init__(self):
        self.ans=float('inf')
        self.sum=0
        
    def backTrack(self,nums,index,sum1,length):
        if length==int(len(nums)/2):
            self.ans=min(self.ans,abs(self.sum-2*sum1))
            return
            
        if index+1-length>int(len(nums)/2):
            return
        
        self.backTrack(nums,index+1,sum1,length)
        self.backTrack(nums,index+1,sum1+nums[index],length+1)
        
    
    def minimumDifference(self, nums: List[int]) -> int:
        self.sum=sum(nums)
        
        self.backTrack(nums,0,0,0)
        
        return self.ans