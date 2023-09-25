class Solution:
    def rotate(self,mat):
        n=len(mat)
        
        for i in range(n):
            for j in range(i):
                t=mat[i][j]
                mat[i][j]=mat[j][i]
                mat[j][i]=t
        
        for i in range(n):
            for j in range(n//2):
                t=mat[i][j]
                mat[i][j]=mat[i][n-1-j]
                mat[i][n-1-j]=t
    
    def equal(self,m1,m2):
        n=len(m1)
        
        for i in range(n):
            for j in range(n):
                if m1[i][j]!=m2[i][j]:
                    return False
        
        return True
    
    def findRotation(self, mat: List[List[int]], target: List[List[int]]) -> bool:
        if self.equal(mat,target):
            return True
        
        self.rotate(mat)
        
        if self.equal(mat,target):
            return True
        
        self.rotate(mat)
        
        if self.equal(mat,target):
            return True
        
        self.rotate(mat)
        
        if self.equal(mat,target):
            return True
        
        return False