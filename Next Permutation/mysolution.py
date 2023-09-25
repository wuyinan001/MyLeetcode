class Solution:
    
    def exchange(self,array,i,j):
        t=array[i]
        array[i]=array[j]
        array[j]=t
    
    def sort(self,array,lo,hi):
        if hi<=lo:
            return
        
        k=self.partition(array,lo,hi)
        self.sort(array,lo,k-1)
        self.sort(array,k+1,hi)
        
    def partition(self,array,lo,hi):
        v=array[lo]
        i=lo+1
        j=hi
        while True:
            while i<=hi and array[i]<v:
                i+=1
            
            while j>=0 and array[j]>v:
                j-=1
            
            if i>=j:
                break
            
            self.exchange(array,i,j)
            i+=1
            j-=1
        
        self.exchange(array,lo,j)
        return j
    
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        i=n-1
        
        while i>0:
            if nums[i-1]<nums[i]:
                break
            i-=1
        
        if i==0:
            self.sort(nums,0,n-1)
            return
        
        i-=1
        j=n-1
        
        while nums[j]<=nums[i]:
            j-=1
        
        self.exchange(nums,i,j)
        self.sort(nums,i+1,n-1)