class Solution:
    def toString(self,arr,n):
        ans=[]
        for i in range(n):
            s=""
            for j in range(n):
                s=s+arr[i][j]
            ans.append(s)
        
        return ans
    
    def backTrack(self,row,cols,diagnals,anti_diagnals,arr,list2,n):                
        if row==n:
            list2.append(self.toString(arr,n))
            return
        
        for col in range(n):
            if (col in cols) or (row-col in diagnals) or (row+col in anti_diagnals):
                continue
            
            arr[row][col]='Q'
            cols.add(col)
            diagnals.add(row-col)
            anti_diagnals.add(row+col)
            self.backTrack(row+1,cols,diagnals,anti_diagnals,arr,list2,n)
        
            arr[row][col]='.'
            cols.remove(col)
            diagnals.remove(row-col)
            anti_diagnals.remove(row+col)
                        
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols=set([])
        diagnals=set([])
        anti_diagnals=set([])
        
        arr=[['.' for _ in range(n)] for _ in range(n)]
        ans=[]
        
        self.backTrack(0,cols,diagnals,anti_diagnals,arr,ans,n)
        
        return ans