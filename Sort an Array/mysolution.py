class Solution:
    def exchange(self,nums,i,j):
        t=nums[i]
        nums[i]=nums[j]
        nums[j]=t
    
    def sort(self,nums,lo,hi):
        if lo>=hi:
            return
        
        lt=lo
        i=lo+1
        v=nums[lo]
        ht=hi
        
        while i<=ht:
            if nums[i]<v:
                self.exchange(nums,i,lt)
                i+=1
                lt+=1
            elif nums[i]>v:
                self.exchange(nums,i,ht)
                ht-=1
            else:
                i+=1
        
        self.sort(nums,lo,lt-1)
        self.sort(nums,ht+1,hi)
    
    def sortArray(self, nums: List[int]) -> List[int]:
        self.sort(nums,0,len(nums)-1)
        return nums