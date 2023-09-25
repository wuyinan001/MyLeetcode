class Solution:
    def addBinary(self, a: str, b: str) -> str:
        n1=len(a)
        n2=len(b)
        
        carry=0
        
        ans=[]
        
        i=n1-1
        j=n2-1
        
        while i>=0 and j>=0:
            sum1=int(a[i])+int(b[j])+carry
            ans.append(sum1%2)
            carry=int(sum1/2)
            i-=1
            j-=1
        
        while i>=0:
            sum1=int(a[i])+carry
            ans.append(sum1%2)
            carry=int(sum1/2)
            i-=1
        
        while j>=0:
            sum1=int(b[j])+carry
            ans.append(sum1%2)
            carry=int(sum1/2)
            j-=1
        
        if carry>0:
            ans.append(carry)
            
        ans.reverse()
        
        res=""
        for i in ans:
            res=res+str(i)
        
        return res