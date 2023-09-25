class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows==1:
            return [[1]]
        elif numRows==2:
            return [[1],[1,1]]
        
        ans=[[1],[1,1]]
        
        for i in range(2,numRows):
            newRow=[]
            for j in range(len(ans[-1])-1):
                newRow.append(ans[-1][j]+ans[-1][j+1])
            newRow.insert(0,1)
            newRow.append(1)
            ans.append(newRow)
        
        return ans