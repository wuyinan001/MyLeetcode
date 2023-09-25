class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        set1=set([])
        for p in points:
            set1.add((p[0],p[1]))
        
        list1=[]
        for p in set1:
            list1.append(p)
        
        ans=float('inf')
        
        n=len(list1)
        
        for i in range(n-1):
            for j in range(i+1,n):
                p1=list1[i]
                p2=list1[j]
                if p1[0]!=p2[0] and p1[1]!=p2[1] and ((p1[0],p2[1]) in set1) and ((p2[0],p1[1]) in set1):
                    ans=min(ans,abs(p1[0]-p2[0])*abs(p1[1]-p2[1]))
        
        return ans if ans!=float('inf') else 0