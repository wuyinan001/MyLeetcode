class Solution {
    
    private boolean searchMatrix(int[][] matrix, int row_lo, int row_hi, int col_lo, int col_hi, int target)
    {   
        
        if((row_lo>row_hi)||(col_lo>col_hi))
            return false;
        
        int row_mid=row_lo+(row_hi-row_lo)/2, col_mid=col_lo+(col_hi-col_lo)/2;
        
        if(target==matrix[row_mid][col_mid])
            return true;
        
        if(target<matrix[row_mid][col_mid])
            return searchMatrix(matrix,0,row_mid-1,0,col_mid,target)||searchMatrix(matrix,row_mid,row_mid,0,col_mid-1,target)||searchMatrix(matrix,0,row_mid-1,col_mid+1,col_hi,target)||searchMatrix(matrix,row_mid+1,row_hi,0,col_mid-1,target);
        
        return searchMatrix(matrix,row_mid+1,row_hi,col_mid,col_hi,target)||searchMatrix(matrix,row_mid,row_mid,col_mid+1,col_hi,target)||searchMatrix(matrix,0,row_mid-1,col_mid+1,col_hi,target)||searchMatrix(matrix,row_mid+1,row_hi,0,col_mid-1,target);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length, m=matrix[0].length;
        
        return searchMatrix(matrix,0,n-1,0,m-1,target);
    }
}