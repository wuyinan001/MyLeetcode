class Solution:
    def reverseArray(self,arr,hi):
        for i in range(hi//2+1):
            t=arr[i]
            arr[i]=arr[hi-i]
            arr[hi-i]=t
    
    def pSort(self,arr,hi):
        ans=[]
        
        if hi==0:
            return ans
        
        max_idx=0
        max1=arr[0]
        
        for i in range(hi+1):
            if max1<arr[i]:
                max1=arr[i]
                max_idx=i
        
        if max_idx!=0:
            ans.append(max_idx+1)
            self.reverseArray(arr,max_idx)
            #print(arr)
            
        ans.append(hi+1)
        self.reverseArray(arr,hi)
        #print(arr)
        ans.extend(self.pSort(arr,hi-1))
        
        
        return ans
    
    def pancakeSort(self, arr: List[int]) -> List[int]:
        return self.pSort(arr,len(arr)-1)