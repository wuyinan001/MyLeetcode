class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        n=len(triangle)
        
        if n==0:
            return 0
        
        # L[i][j] contains min accumulative sum to get triangle[i][j]
        L=[]
        
        L.append([triangle[0][0]])
        
        for i in range(1,n):
            l=[]
            for j in range(0,i+1):
                if j==0:
                    l.append(L[i-1][0]+triangle[i][j])
                elif j==i:
                    l.append(L[i-1][-1]+triangle[i][j])
                else:
                    l.append(min(L[i-1][j-1],L[i-1][j])+triangle[i][j])
            
            L.append(l)
        
        return min(L[-1])      