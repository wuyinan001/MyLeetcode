class Solution:
    
    def __init__(self):
        self.dict1={}
        self.size=0
    
    def findOddNext(self):
        stack=[]
        ans=[-1 for i in range(self.size)]
        
        list1=[]
        for key in self.dict1.keys():
            list1.append(key)
        
        def myFunc(e):
            return self.dict1[e]
        
        list1.sort(key=myFunc)
        
        for i in list1:
            while stack and i>stack[-1]:
                ans[stack.pop()]=i
            stack.append(i)
        
        return ans
    
    def findEvenNext(self):
        stack=[]
        ans=[-1 for i in range(self.size)]
        
        list1=[]
        for key in self.dict1.keys():
            list1.append(key)
        
        def myFunc(e):
            return self.dict1[e]
        
        list1.sort(key=myFunc, reverse=True)
        
        for i in list1:
            while stack and i>stack[-1]:
                ans[stack.pop()]=i
            stack.append(i)
        
        return ans
    
    def oddEvenJumps(self, arr: List[int]) -> int:
        self.size=len(arr)
        for i in range(self.size):
            self.dict1[i]=arr[i]
            
        oddNext=self.findOddNext()
        evenNext=self.findEvenNext()
        
        #print(oddNext)
        
        ans=0
        
        odd=[False for i in range(self.size)]
        even=odd[:]
        
        odd[-1]=True
        even[-1]=True
        
        for i in range(self.size-1,-1,-1):
            if oddNext[i]!=-1 and even[oddNext[i]]:
                odd[i]=True
            if evenNext[i]!=-1 and odd[evenNext[i]]:
                even[i]=True
                
        for i in range(self.size):
            if odd[i]:
                ans+=1
        
        return ans