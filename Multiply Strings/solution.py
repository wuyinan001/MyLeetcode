class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        n1=len(num1)
        n2=len(num2)
        ans=[0 for i in range(n1+n2)]
        
        carry=0
        
        i=n1-1
        j=n2-1
        
        while j>=0:
            while i>=0:
                ans[i+j+1]=int(num1[i])*int(num2[j])+carry+ans[i+j+1]
                carry=int(ans[i+j+1]/10)
                ans[i+j+1]=ans[i+j+1]%10
                i-=1
            
            ans[i+j+1]+=carry
            carry=0
            i=n1-1
            j-=1

        while len(ans)>1 and ans[0]==0:
            ans.pop(0)
        
        ans_s=''
        for i in ans:
            ans_s=ans_s+str(i)
            
        return ''.join(ans_s)