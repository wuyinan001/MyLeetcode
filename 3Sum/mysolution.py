class Solution:
    def twoSum(self,nums,index,list1):
        set1=set([])
        i=index+1
        while i<len(nums):
            if -nums[index]-nums[i] in set1:
                list1.append([nums[index],-nums[index]-nums[i],nums[i]])
                while i<len(nums)-1 and nums[i]==nums[i+1]:
                    i+=1
            else:
                set1.add(nums[i])
            
            i+=1
    
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans=[]
        for i in range(len(nums)):
            if nums[i]>0:
                break
            if i>0 and nums[i]==nums[i-1]:
                continue
            self.twoSum(nums,i,ans)
        
        return ans