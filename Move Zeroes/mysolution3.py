class Solution:
    def swap(self,nums,i,j):
        t=nums[i]
        nums[i]=nums[j]
        nums[j]=t
        
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        
        read=0
        write=0
        
        while write<n and read<n:
            if nums[write]==0 and nums[read]==0:
                read+=1
            elif nums[write]==0 and nums[read]!=0:
                self.swap(nums,write,read)
                read+=1
                write+=1
            else:
                read+=1
                write+=1