class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length, m=matrix[0].length;
        
        int row=n-1, col=0;
        
        while(row>=0&&col<=m-1)
        {
            if(target<matrix[row][col])
                row--;
            else if(target>matrix[row][col])
                col++;
            else
                return true;
        }
        
        return false;
    }
}