class Solution:
    
    def swap(self,array,i,j):
        t=array[i]
        array[i]=array[j]
        array[j]=t
    
    def backTrack(self,array1,array2,index):
        if index==len(array1):
            return 0
        
        if array1[index]!=array2[index]:
            ans=inf
            
            for i in range(index+1,len(array1)):
                if array2[index]==array1[i] and array2[i]!=array1[i]:
                    self.swap(array1,index,i)
                    ans=min(ans,1+self.backTrack(array1,array2,index+1))
                    self.swap(array1,index,i)
            
            return ans
        else:
            return self.backTrack(array1,array2,index+1)
        
        
        
    def kSimilarity(self, s1: str, s2: str) -> int:
        a1=[]
        for i in s1:
            a1.append(i)
            
        a2=[]
        for i in s2:
            a2.append(i)
            
        return self.backTrack(a1,a2,0)