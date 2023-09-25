class Solution:
    def swap(self,nums,i,j):
        t=nums[i]
        nums[i]=nums[j]
        nums[j]=t
        
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        v=1
        n=len(nums)
        lt=0
        ht=n-1
        i=0
        
        while i<=ht:
            if nums[i]<v:
                self.swap(nums,i,lt)
                i+=1
                lt+=1
            elif nums[i]>v:
                self.swap(nums,i,ht)
                ht-=1
            else:
                i+=1