class Solution:
    def minAreaRect(self, points: List[List[int]]) -> int:
        set1=set([])
        for p in points:
            set1.add((p[0],p[1]))
        
        ans=inf
        n=len(points)
        
        for i in range(n-1):
            for j in range(i+1,n):
                if points[i][0]!=points[j][0] and points[i][1]!=points[j][1] and (points[i][0],points[j][1]) in set1 and (points[j][0],points[i][1]) in set1:
                        ans=min(ans,abs((points[i][0]-points[j][0])*(points[i][1]-points[j][1])))
        
        return ans if ans!=inf else 0