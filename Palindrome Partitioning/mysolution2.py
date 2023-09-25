class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n=len(s)
        
        if n==0:
            return [[]]
        elif n==1:
            return [[s]]
        
        P=[[False for _ in range(n)] for _ in range(n)]
        
        for i in range(n):
            P[i][i]=True
            
        for i in range(n-1):
            if s[i]==s[i+1]:
                P[i][i+1]=True
        
        for gap in range(2,n):
            for i in range(n-gap):
                j=i+gap
                if s[i]==s[j] and P[i+1][j-1]:
                    P[i][j]=True
        
        ans=[]
        
        for i in range(n):
            if P[0][i]:
                prefix=s[:i+1]
                list1=self.partition(s[i+1:])
                for l in list1:
                    l.insert(0,prefix)
                    ans.append(l)
        
        return ans