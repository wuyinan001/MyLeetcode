class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        self.n=len(matrix)
        self.m=len(matrix[0])
        self.cum=[[0 for _ in range(self.m)] for _ in range(self.n)]
        
        self.cum[0][0]=matrix[0][0]
        
        for i in range(1,self.n):
            self.cum[i][0]=self.cum[i-1][0]+matrix[i][0]
        
        for j in range(1,self.m):
            self.cum[0][j]=self.cum[0][j-1]+matrix[0][j]
            
        for i in range(1,self.n):
            for j in range(1,self.m):
                self.cum[i][j]=self.cum[i-1][j]+self.cum[i][j-1]-self.cum[i-1][j-1]+matrix[i][j]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        if row1==0 and col1==0:
            return self.cum[row2][col2]
        elif row1==0:
            return self.cum[row2][col2]-self.cum[row2][col1-1]
        elif col1==0:
            return self.cum[row2][col2]-self.cum[row1-1][col2]
        else:
            return self.cum[row2][col2]-self.cum[row1-1][col2]-self.cum[row2][col1-1]+self.cum[row1-1][col1-1]
        


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)