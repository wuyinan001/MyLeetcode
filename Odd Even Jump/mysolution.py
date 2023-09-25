class Solution:
    def __init__(self):
        self.dict={}
        
    def findOddNext(self,arr):
        list1=list(self.dict.keys())
        list1.sort(key=lambda x:self.dict[x])
        n=len(arr)
        
        ans=[-1 for i in range(n)]
        
        stack=[]
        
        for i in list1:
            while stack and i>stack[-1]:
                ans[stack.pop()]=i
            stack.append(i)
        
        return ans
    
    def findEvenNext(self,arr):
        list1=list(self.dict.keys())
        list1.sort(key=lambda x:-self.dict[x])
        n=len(arr)
        
        ans=[-1 for i in range(n)]
        
        stack=[]
        
        for i in list1:
            while stack and i>stack[-1]:
                ans[stack.pop()]=i
            stack.append(i)
        
        return ans
        
    def oddEvenJumps(self, arr: List[int]) -> int:
        n=len(arr)
        for i in range(n):
            self.dict[i]=arr[i]
            
        oddNext=self.findOddNext(arr)
        evenNext=self.findEvenNext(arr)
        
        odd=[0 for i in range(n)]
        even=[0 for i in range(n)]
        
        odd[n-1]=1
        even[n-1]=1
        
        for i in range(n-2,-1,-1):
            if oddNext[i]!=-1 and even[oddNext[i]]==1:
                odd[i]=1
            if evenNext[i]!=-1 and odd[evenNext[i]]==1:
                even[i]=1
        
        return sum(odd)