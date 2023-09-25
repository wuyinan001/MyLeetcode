class Solution:
    def backTrack(self,s,index,list1,list2,P):
        n=len(s)
        
        if index==n:
            list2.append(list1[:])
            return
        
        for i in range(index,n):
            if P[index][i]:
                list1.append(s[index:i+1])
                self.backTrack(s,i+1,list1,list2,P)
                list1.pop()
    
    def partition(self, s: str) -> List[List[str]]:
        n=len(s)
        P=[[False for _ in range(n)] for _ in range(n)]
        
        for i in range(n):
            P[i][i]=True
        
        for i in range(n-1):
            if s[i]==s[i+1]:
                P[i][i+1]=True
        
        for gap in range(2,n):
            for i in range(n-gap):
                j=i+gap
                if P[i+1][j-1] and s[i]==s[j]:
                    P[i][j]=True
        
        ans=[]
        self.backTrack(s,0,[],ans,P)
        
        return ans
        