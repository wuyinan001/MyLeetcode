class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n=len(matrix)
        m=len(matrix[0])
        
        row=n-1
        col=0
        
        while row>=0 and col<m:
            if matrix[row][col]==target:
                return True
            elif target<matrix[row][col]:
                row-=1
            else:
                col+=1
        
        return False