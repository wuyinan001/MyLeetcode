class Solution(object):
    def oddEvenJumps(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        n=len(A)
        
        if n==0:
            return 0
        
        if n==1:
            return 1
        
        B=sorted(range(n), key=lambda i: A[i])
        
        oddnext=self.make(B)
        
        B=sorted(range(n), key=lambda i: -A[i])
        
        evennext=self.make(B)
        
        odd=[False]*n
        even=[False]*n
        
        odd[-1]=True
        even[-1]=True
        
        count=1
        
        for i in range(n-2,-1,-1):
            if oddnext[i]!=None and even[oddnext[i]]==True:
                odd[i]=True
            if evennext[i]!=None and odd[evennext[i]]==True:
                even[i]=True
            
            if odd[i]==True:
                count=count+1
        
        return count
        
        
    def make(self,B):
        
        n=len(B)
        stack=[]
        ans=[None]*n
        
        for i in B:
            while stack and i>stack[-1]:
                ans[stack.pop()]=i
            stack.append(i)
        
        return ans