class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int n=matrix.length, m=matrix[0].length;
        
        for(int diff=m-1;diff>=-(n-1);diff--)
        {
            int x=matrix[Math.max(0,-diff)][Math.max(0,-diff)+diff];
            for(int i=Math.max(0,-diff)+1;i<Math.min(n,m-diff);i++)
            {
                if(x!=matrix[i][i+diff])
                    return false;
            }
        }
        
        return true;
    }
}