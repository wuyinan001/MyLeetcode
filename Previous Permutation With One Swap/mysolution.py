class Solution:
    
    def exchange(self,arr,i,j):
        t=arr[i]
        arr[i]=arr[j]
        arr[j]=t
    
    def prevPermOpt1(self, arr: List[int]) -> List[int]:
        n=len(arr)
        i=n-1
        
        while i>0:
            if arr[i-1]<=arr[i]:
                i-=1
            else:
                break
        
        if i==0:
            return arr
        
        i-=1
        j=n-1
        
        while j>i:
            if arr[j]<arr[i]:
                break
            else:
                j-=1
        
        while arr[j-1]==arr[j]:
            j-=1
        
        self.exchange(arr,i,j)
        return arr