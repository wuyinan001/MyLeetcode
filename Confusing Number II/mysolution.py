class Solution:
    
    def rotate(self,n):
        ans=0
        while n>0:
            k=n%10
            if k==6:
                k=9
            elif k==9:
                k=6
            
            ans=ans*10+k
            n=(int)(n/10)
        
        return ans
    
    def confusingNumberII(self, n: int) -> int:
        stack=[]
        
        stack.append(1)
        stack.append(6)
        stack.append(8)
        stack.append(9)
        
        ans=0
        
        while stack:
            num=stack.pop()
            rot=self.rotate(num)
            
            if rot!=num and num<=n:
                #print("num",num,"rot",rot)
                ans+=1
            
            ten=num*10
            if ten<=n:
                stack.append(ten)

            if ten+1<=n:
                stack.append(ten+1)

            if ten+6<=n:
                stack.append(ten+6)

            if ten+8<=n:
                stack.append(ten+8)

            if ten+9<=n:
                stack.append(ten+9)
        
        return ans