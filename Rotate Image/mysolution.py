class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n=len(matrix)
        for i in range(n):
            for j in range(i+1,n):
                t=matrix[i][j]
                matrix[i][j]=matrix[j][i]
                matrix[j][i]=t
        
        for i in range(n):
            for j in range(n//2):
                t=matrix[i][j]
                matrix[i][j]=matrix[i][n-1-j]
                matrix[i][n-1-j]=t