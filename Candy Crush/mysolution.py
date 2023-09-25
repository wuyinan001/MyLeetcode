class Solution:
    def candyCrush(self, board: List[List[int]]) -> List[List[int]]:
        crush=False
        
        n=len(board)
        m=len(board[0])
        
        for i in range(n):
            for j in range(m-2):
                ab=abs(board[i][j])
                if ab>0 and abs(board[i][j+1])==ab and abs(board[i][j+2])==ab:
                    crush=True
                    board[i][j]=board[i][j+1]=board[i][j+2]=-ab
        
        for j in range(m):
            for i in range(n-2):
                ab=abs(board[i][j])
                if ab>0 and abs(board[i+1][j])==ab and abs(board[i+2][j])==ab:
                    crush=True
                    board[i][j]=board[i+1][j]=board[i+2][j]=-ab
        
        for j in range(m):
            row_write=n-1
            for i in range(n-1,-1,-1):
                if board[i][j]>0:
                    board[row_write][j]=board[i][j]
                    row_write-=1
            
            while row_write>=0:
                board[row_write][j]=0
                row_write-=1
        
        if crush:
            return self.candyCrush(board)
        else:
            return board