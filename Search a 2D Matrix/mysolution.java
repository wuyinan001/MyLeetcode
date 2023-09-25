class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix.length;
        
        if(n==0)
            return false;
        
        int m=matrix[0].length;
        
        int lo=0,hi=n*m-1;
        int mid;
        
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            
            int i=mid/m;
            int j=mid%m;
            
            if(target==matrix[i][j])
                return true;
            
            if(target<matrix[i][j])
                hi=mid-1;
            else
                lo=mid+1;
        }
        
        return false;
    }
}