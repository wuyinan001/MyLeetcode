class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        n1=len(num1)
        n2=len(num2)

        i=n1-1
        j=n2-1

        carry=0
        sum1=0
        ans=[]

        while i>=0 and j>=0:
            sum1=carry+int(num1[i])+int(num2[j])
            ans.append(sum1%10)
            carry=int(sum1/10)
            i-=1
            j-=1

        while i>=0:
            sum1=carry+int(num1[i])
            ans.append(sum1%10)
            carry=int(sum1/10)
            i-=1

        while j>=0:
            sum1=carry+int(num2[j])
            ans.append(sum1%10)
            carry=int(sum1/10)
            j-=1
        
        if carry!=0:
            ans.append(carry)
        
        ans.reverse()

        res=""
        for i in ans:
            res=res+str(i)

        return res
