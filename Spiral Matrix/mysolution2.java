class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> ans=new ArrayList();
        
        int n=matrix.length;
        
        if(n==0)
            return ans;
        
        int m=matrix[0].length;
        
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int r=0,c=-1;
        
        // d: direction
        // 0:right; 1:down; 2:left; 3:up
        int d=0;
        // row: how much row steps to move
        // col: how much col steps to move
        int row=n,col=m;
        int increment=col;
            
        while(true)
        {   
            if(increment==0)
                break;
            
            for(int i=1;i<=increment;i++)
            {
                r=r+dir[d][0];
                c=c+dir[d][1];
                
                ans.add(matrix[r][c]);
   
            }
            
            if(d==0||d==2)
            {
                row--;
                increment=row;
            }
            else
            {
                col--;
                increment=col;
            }
                
            
            d=(d+1)%4;
        }
        
        return ans;
    }
}